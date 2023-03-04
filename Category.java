
import java.sql.*;
import javax.swing.*;


public class Category {

   public static void main(String[] args) {
      // url of the database that rahim created
      String url = "jdbc:hsqldb:hsql://localhost/";

      // the username and password to connect
      String user = "SA";
      String password = "";

      JFrame frame = new JFrame();
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



      try {
         Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         String sql = "SELECT sum(amount) as expense FROM expenses group by category ";
         ResultSet rs = stmt.executeQuery(sql);

         while(rs.next()) {
            float expense = rs.getInt("expense");
            String cat = rs.getString("category");

            
            JLabel label = new JLabel("Category: " + cat + " has: " + expense + " DA. ");
            
            frame.getContentPane().add(label);

            frame.setVisible(true);
         }
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException e) {
         e.printStackTrace();
      }
   }
}