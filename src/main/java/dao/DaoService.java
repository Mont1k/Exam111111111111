package dao;

import UserDao.User;

import java.sql.SQLException;
import java.util.List;

public interface DaoService {
    void createDaoTable() throws SQLException;
    void saveDao(String name, Long id, int age);
    User getById(Long id) throws SQLException;
    void clearById(Long id) throws SQLException;


}
