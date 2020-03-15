package javamysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MainSelect {

    public static void main(String[] args) {
        Connection connect = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/james"
                    + "?user=admin&password=1234");

            s = connect.createStatement();

            if (connect != null) {
                System.out.println("Database monsit_pasida.");
                String sql = " SELECT * FROM Employees ";
                ResultSet rec = s.executeQuery(sql);
                while ((rec != null) && (rec.next()))
                {
                    
                    System.out.print(rec.getString("id"));
                    System.out.print(" - ");
                    System.out.print(rec.getString("name"));
                    System.out.print(" - ");
                    System.out.print(rec.getString("email"));
                    System.out.print(" - ");
                    System.out.print(rec.getString("salary"));
                    System.out.println("");// ln คือการขึ้นบรรทัดใหม่
                }
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
