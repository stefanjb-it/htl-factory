package fsst.htlklu.htl_factory.DB;

import java.sql.*;

public class DB_Connection {

    private static Connection connection;

    private static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mysql.stevenelectric.icu:3306/htl_factory", "JDBC", "testingJDBC");
        } catch (SQLException | ClassNotFoundException e1) {
            System.out.println(e1.toString());
        }
    }

    public static Connection getConn() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

}
