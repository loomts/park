package database;


import java.sql.*;
import java.util.ResourceBundle;


public class Conn {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    // 根据属性配置文件key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String pwd = bundle.getString("pwd");
    public static Statement getConn() {
        if (stmt == null) {
            try {
                Class.forName(driver);
                con = (Connection) DriverManager.getConnection(url, user, pwd);
                stmt = con.createStatement();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return stmt;
    }
}
