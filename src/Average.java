import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Average {
     public void average(Connection con, Scanner sc) {
          Quries q = new Quries();
          Animation.Animations(50, 10);
          try (PreparedStatement ps = con.prepareStatement(q.average); ResultSet resultSet = ps.executeQuery()) {
               System.out.println("---------------HERES THE AVERAGE OF ALL SUBJECTS AND STUDENTS-------------");
               if (resultSet.next()) {
                    double avgSubject1 = resultSet.getDouble("MATHS");
                    double avgSubject2 = resultSet.getDouble("PHYSICS");
                    double avgSubject3 = resultSet.getDouble("CHEMISTRY");
                    double avgSubject4 = resultSet.getDouble("BIOLOGY");
                    double avgSubject5 = resultSet.getDouble("ENGLISH");
                    double avgTotal = resultSet.getDouble("avg_total");

                    // Display the results in a table format
                    System.out.println("-----------------------------------");
                    System.out.println("Subject             Average  ");
                    System.out.println("-----------------------------------");
                    System.out.println("MATHS           :   \t" + avgSubject1);
                    System.out.println("PHYSICS         :  \t" + avgSubject2);
                    System.out.println("CHEMISTRY    :  \t" + avgSubject3);
                    System.out.println("BIOLOGY        :  \t" + avgSubject4);
                    System.out.println("ENGLISH        :   \t" + avgSubject5);
                    System.out.println("-----------------------------------");
                    System.out.println("Average Marks :   \t" + avgTotal);
               } else {
                    System.out.println("No data found!");
               }

          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }
}
