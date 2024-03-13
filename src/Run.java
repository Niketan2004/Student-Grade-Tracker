import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
     public static void main(String[] args) {
          final String url = "jdbc:mysql://localhost:3306/Your_Database_name";  //Here you have replace Your_Database_name with name of the database that you have given.
          final String userName = "sql_username";  //replace this with your username of mysql workbench
          final String password = "sql_password";      // replace this with passworf of your mysql workbench.
          Scanner sc = new Scanner(System.in);
          insert_Grades ig = new insert_Grades();
          add_Student as = new add_Student();
          Average avg = new Average();
          Reports rp = new Reports();

          System.out.println("------------------WELCOME TO GRADING SYSTEM-----------------");
          int c = 0;
          try (Connection con = DriverManager.getConnection(url, userName, password)) {

               boolean validChoice = false;

               do {
                    try {
                         System.out.println(
                                   "1.Add Student \n 2.Insert Grades \n 3.Average \n 4.Display Result \n 5.Exit");
                         System.out.println("Select your Choice :- ");
                         c = sc.nextInt();
                         switch (c) {
                              case 1:
                                   as.add_Students(con, sc);
                                   Animation.Animations(20, 10);
                                   break;

                              case 2:
                                   ig.insert_Grade(con, sc);
                                   Animation.Animations(20, 10);
                                   break;

                              case 3:
                                   avg.average(con, sc);
                                   Animation.Animations(20, 10);
                                   break;

                              case 4:
                                   rp.report(con, sc);
                                   Animation.Animations(20, 10);
                                   break;

                              case 5:
                                   Animation.Animations(50, 10);
                                   System.out.println("Exited Successfully!");
                                   validChoice = true;
                                   break;
                              default:
                                   System.out.println("Please Enter Valid Choice!");
                                   break;
                         }
                    } catch (InputMismatchException e) {
                         System.out.println("Invalid input. Please enter a number.");
                         sc.nextLine(); // Consume the invalid input
                    }
               } while (!validChoice);
               sc.close();
          } catch (SQLException e) {
               System.out.println("Error : " + e.getMessage());
          }
     }
}
