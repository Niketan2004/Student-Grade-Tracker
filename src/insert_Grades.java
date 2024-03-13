import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class insert_Grades {
     Quries q = new Quries();

     public void insert_Grade(Connection con, Scanner sc) {
          System.out.println("--------INSERTING MARKS OF STUDENTS----------");
          int c = 0;
          while (c != 3) {

               System.out.println("1.Student exists \n 2.Fresh student \n 3.Exit");
               System.out.print("Enter your choice:- ");
               c = sc.nextInt();
               if (c == 1) {
                    System.out.println("Enter the name of Student :- ");
                    String name = sc.next();

                    System.out.println("Enter Student ID :- ");
                    int id = sc.nextInt();
                    boolean studentExists = false;
                    Animation.Animations(50, 10);
                    try (PreparedStatement ps = con.prepareStatement(q.check)) {
                         ps.setInt(1, id);
                         ps.setString(2, name);
                         ResultSet rs = ps.executeQuery();
                         if (rs.next()) {
                              studentExists = true;

                              System.out.println("Student Exists in Database! ");
                         } else {
                              System.out.println("Student does not Exists! Please check your Entries.");
                         }
                    } catch (Exception e) {
                         System.out.println(e.getMessage());
                    }

                    if (studentExists) {
                         System.out.println(
                                   "Note : *Please enter correct Marks. \n *Subject sequence is :- 1.MATHS  2.PHYSICS 3.CHEMISTRY 4.BIOLOGY 5.ENGLISH.\n *PLEASE ENTER THE MARKS IN ABOVE SEQUENCE.");
                         System.out.println("Enter your Marks Here:- ");
                         int[] marks = new int[5];
                         for (int i = 0; i < 5; i++) {
                              marks[i] = sc.nextInt();
                         }
                         try (PreparedStatement ps = con.prepareStatement(q.updateQuery)) {
                              for (int i = 0; i < 5; i++) {
                                   ps.setInt(i + 1, marks[i]);
                              }
                              ps.setInt(6, id);
                              ps.setString(7, name);
                              ps.addBatch();
                              ps.executeBatch();
                              int totalMarks = 0;
                              for (int mark : marks) {
                                   totalMarks += mark;
                              }
                              // Update TOTAL_MARKS column in the database
                              try (PreparedStatement tm = con.prepareStatement(q.sumTotal)) {
                                   tm.setInt(1, totalMarks);
                                   tm.setInt(2, id);
                                   tm.executeUpdate();

                                   System.out.println("Marks are Added Successfully!");
                              }
                         } catch (Exception e) {
                              System.out.println(e.getMessage());
                         }

                    }
               } else if (c == 2) {
                    System.out.println("Enter the name of Student :- ");
                    String name = sc.next();
                    Animation.Animations(50, 10);
                    System.out.println(
                              "Note : *Please enter correct Marks. \n *Subject sequence is :- 1.MATHS  2.PHYSICS 3.CHEMISTRY 4.BIOLOGY 5.ENGLISH.\n *PLEASE ENTER THE MARKS IN ABOVE SEQUENCE.");
                    System.out.println("Enter your Marks Here:- ");
                    int[] marks = new int[5];
                    for (int i = 0; i < 5; i++) {
                         marks[i] = sc.nextInt();
                    }
                    try (PreparedStatement ps = con.prepareStatement(q.insertQuery)) {
                         // ps.setInt(1, id);
                         ps.setString(1, name);
                         for (int i = 0; i < 5; i++) {
                              ps.setInt(i + 2, marks[i]); // Assuming you have 5 columns in your updateQuery
                         }
                         ps.addBatch();
                         ps.executeBatch();
                         Animation.Animations(25, 10);
                         System.out.println("New Student and Marks are  Added Successfully!");

                    } catch (Exception e) {
                         System.out.println(e.getMessage());
                    }

               }
          }

     }

}
