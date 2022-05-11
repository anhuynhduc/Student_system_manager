package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://DESKTOP-5K3GMSS/db_qlhv;instance=SQLEXPRESS;user=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
}