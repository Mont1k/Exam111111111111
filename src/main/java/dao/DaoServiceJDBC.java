package dao;

import DBConnection.DBConnection;
import UserDao.User;

import java.sql.*;
import java.util.List;

public class DaoServiceJDBC implements DaoService {
    DBConnection dbc = new DBConnection();

    public DaoServiceJDBC() throws SQLException {
    }

    @Override
    public void createDaoTable() throws SQLException {
        DBConnection dbc = new DBConnection();
        String query1 =
                "create table if not exists users(" +
                        "id serial primary key, " +
                        "name varchar(50), " +
                        " age int);";
        try (Connection connection = dbc.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query1);
            System.out.println("ПОЛУЧИЛООООООСЬ!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveDao(String name, Long id, int age) {

        String query2 = "insert into users(name,id,age) values(?,?,?)";
        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(query2)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Name" + name + "сохранен");

        } catch (SQLException e) {
            System.out.println("Save ne poluchilos");
        }

    }

    @Override
    public User getById(Long id) throws SQLException {

        String query3 = "select * from users where id=? ";
        try (Connection connection = dbc.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query3)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
            }
            System.out.println("Через айдишник получен");
        }catch (SQLException e){
            System.out.println("Через айдишник не получен");
        }
return null;    }

    @Override
    public void clearById(Long id) throws SQLException {
    String query4 = "delete from users where id =?";
    try (PreparedStatement prepareStatement = dbc.getConnection().prepareStatement(query4)) {
    prepareStatement.setLong(1,id);
    prepareStatement.execute();
        System.out.println("Isthedi");
    }

    catch (SQLException e) {
    throw new RuntimeException(e);
    }
    }
}




