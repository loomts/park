package database;

import com.mysql.jdbc.Connection;

import java.sql.*;


public class Conn {
    private static Connection con = null;
    private static Statement stmt = null;
    private static final String url = "jdbc:mysql://localhost:3306/EP1?characterEncoding=utf8";
    private static final String user = "loomt";
    private static final String pwd = "123456";

    public static Statement getConn() {
        if (stmt == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, user, pwd);
                stmt = con.createStatement();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return stmt;
    }
}
