package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static database.Conn.getConn;

public class Utils {

    public static List deviceDetail(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select deviceId,name,gisLon,gisLat,traffic,upwardSpeed,downwardSpeed,cpuRate from deviceDetail " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    if(resultSetMetaData.getColumnName(i).toString().equals("gisLon")) rowData.put(resultSetMetaData.getColumnName(i), Double.parseDouble(String.format("%.7f",(121.66+((int)(Math.random()*900000)+100000)*0.00000001))));
                    else if(resultSetMetaData.getColumnName(i).toString().equals("gisLat")) rowData.put(resultSetMetaData.getColumnName(i), Double.parseDouble(String.format("%.7f",(31.14+((int)(Math.random()*900000)+100000)*0.00000001))));
                    else rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List deviceTraffic(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from deviceTraffic " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List histFlow(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from histFlow " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List nowFlow(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from nowFlow " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List siteFlow(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from siteFlow " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List siteHealth(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from siteHealth " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List siteUserNumber(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from siteUserNumber " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List siteWlan(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from siteWlan " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List user(String limit) {
        List list = new ArrayList();
        try {
            ResultSet rs = getConn().executeQuery("select * from user " + limit);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int len = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= len; i++) {
                    rowData.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String args[]) {
        try {
            //System.out.println(deviceDetail("where name='device1'"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
