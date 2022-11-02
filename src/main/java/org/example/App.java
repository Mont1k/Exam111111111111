package org.example;

import DBConnection.DBConnection;
import dao.DaoServiceJDBC;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        DaoServiceJDBC daos = new DaoServiceJDBC();
        daos.createDaoTable();
        daos.saveDao("Mont", 1L,17);
        System.out.println(daos.getById(1L));
        daos.clearById(1L);
    }
}
