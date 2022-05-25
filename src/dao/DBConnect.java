package dao;

import java.sql.Connection;
import java.sql.DriverManager;
/*import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;*/
public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            cons = DriverManager.getConnection(
<<<<<<< HEAD
                    "jdbc:jtds:sqlserver://ADMIN/db_qlhv1;instance=SQLEXPRESS;user=sa;password=123456");
=======
                    "jdbc:jtds:sqlserver://ADMIN/db_qlhv;instance=SQLEXPRESS;user=sa;password=123456");// kết nối SQL
>>>>>>> 8477a27685b20b42d68fa4dc46fa982cc21fc9ba
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } */    
        return cons;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
     /*public ResultSet GetResultSet(String tableName) throws SQLException {
        ResultSet cons = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        cons = stmt.executeQuery(sql);
        return cons;
    }*/
}
