import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Reports {
     void report(Connection con, Scanner sc) {
          Quries q = new Quries();
          System.out.println(" ---------------WELCOME TO THE REPORT  ! ------------- ");
          System.out.println("1. Individual Student Result\n2. College Result\n3. Exit");
          System.out.println("Enter Your Choice: ");
          int c = sc.nextInt();

          if (c == 1) {
               // Code to display individual student result
               Animation.Animations(50, 10);
               displayStudentResult(con, q, sc);

          } else if (c == 2) {
               // Code to display all data in the database
               Animation.Animations(50, 10);
               displayAllData(con, q);

          } else if (c == 3) {
               // Exit option
               Animation.Animations(50, 15);
               System.out.println("Exiting...Done!");
               return;
          } else {
               System.out.println("Invalid option. Please select a valid option.");
          }
     }

     private void displayStudentResult(Connection con, Quries q, Scanner sc) {
          System.out.println("------------ Enter Details ------------");
          System.out.println("Enter Student Id: ");
          int id = sc.nextInt();

          System.out.println("Enter Student name: ");
          String name = sc.next();
          try (PreparedStatement ps = con.prepareStatement(q.check)) {
               ps.setInt(1, id);
               ps.setString(2, name);
               ResultSet rs = ps.executeQuery();

               if (!rs.next()) {
                    System.out.println("No data found for the specified student name and ID.");
                    return;
               }
               Animation.Animations(50, 10);
               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");
               System.out.println(
                         "| Student_name | MATHS | PHYSICS | CHEMISTRY | BIOLOGY | ENGLISH | TOTAL_MARKS | Student_id |");
               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");

               do {
                    String subject1 = rs.getString("MATHS");
                    String subject2 = rs.getString("PHYSICS");
                    String subject3 = rs.getString("CHEMISTRY");
                    String subject4 = rs.getString("BIOLOGY");
                    String subject5 = rs.getString("ENGLISH");
                    int totalMarks = rs.getInt("TOTAL_MARKS");

                    System.out.printf("| %-12s | %-5s | %-7s | %-9s | %-7s | %-7s | %-11s | %-10s |\n",
                              name, subject1, subject2, subject3, subject4, subject5, totalMarks, id);
               } while (rs.next());

               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");
          } catch (Exception e) {
               System.out.println("An error occurred: " + e.getMessage());
          }
     }

     private void displayAllData(Connection con, Quries q) {
          try (PreparedStatement ps = con.prepareStatement(q.select)) {
               ResultSet rs = ps.executeQuery();
              // Animation.Animations(50, 10);
               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");
               System.out.println(
                         "| Student_name | MATHS | PHYSICS | CHEMISTRY | BIOLOGY | ENGLISH | TOTAL_MARKS | Student_id |");
               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");

               while (rs.next()) {
                    String name = rs.getString("Student_name");
                    String subject1 = rs.getString("MATHS");
                    String subject2 = rs.getString("PHYSICS");
                    String subject3 = rs.getString("CHEMISTRY");
                    String subject4 = rs.getString("BIOLOGY");
                    String subject5 = rs.getString("ENGLISH");
                    int totalMarks = rs.getInt("TOTAL_MARKS");
                    int id = rs.getInt("Student_id");

                    System.out.printf("| %-12s | %-5s | %-7s | %-9s | %-7s | %-7s | %-11s | %-10s |\n",
                              name, subject1, subject2, subject3, subject4, subject5, totalMarks, id);
               }

               System.out.println(
                         "+--------------+-------+---------+-----------+---------+---------+-------------+------------+");
          } catch (Exception e) {
               System.out.println("An error occurred: " + e.getMessage());
          }
     }

}
