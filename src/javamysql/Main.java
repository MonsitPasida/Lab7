package javamysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection connect = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/james"
                    + "?user=root&password=root");

            s = connect.createStatement();

            if (connect != null) {
                System.out.println("Database Connected.");
                String sql = " INSERT INTO customers "
                        + " (id,name,email,salary ) "
                        + " VALUES ('3004','ดีจ้า มาแล้ว','ddd@gmail.com','15000')";
                s.execute(sql);
                System.out.println("Recrd Inserted Successfully");
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Close
        try {
            if (connect != null) {
                connect.close();
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
