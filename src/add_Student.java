import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class add_Student {
     void add_Students(Connection con, Scanner sc) {
          Quries q = new Quries();
          int generatedId = -1;
          System.out.println("--------ADDING STUDENT-------");
          System.out.println("You can only add Student in this Choice! ");

          System.out.println("Enter the name of student: ");
          String name = sc.next();
          Animation.Animations(25, 10);
          try (PreparedStatement ps = con.prepareStatement(q.insert, PreparedStatement.RETURN_GENERATED_KEYS)) {
               ps.setString(1, name);
               ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
               if (rs.next()) {
                    generatedId = rs.getInt(1); // Retrieve the generated ID correctly
                    System.out.println("Student Entered Successfully! Student ID: " + generatedId);
               }
          } catch (Exception e) {
               System.out.println("An error occurred: " + e.getMessage());
          }

          // Fetching the generated ID using a separate select query
          try (PreparedStatement psSelect = con.prepareStatement(q.select)) {
               ResultSet rsSelect = psSelect.executeQuery();
               while (rsSelect.next()) {
                    int id = rsSelect.getInt("Student_id");
                    if (id == generatedId) {
                         String studentName = rsSelect.getString("Student_name");
                         System.out.println("Student Name: " + studentName + ", Student ID: " + generatedId);
                         break;
                    }
               }
          } catch (Exception e) {
               System.out.println("An error occurred while fetching generated ID: " + e.getMessage());
          }
     }
}