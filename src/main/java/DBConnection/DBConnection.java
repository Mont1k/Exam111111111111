package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public final Connection connection;
    public DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","nurtohun22");}
    public  Connection getConnection() {
        return connection;}


}
