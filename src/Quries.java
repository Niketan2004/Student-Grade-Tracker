public class Quries {

     String insert = "INSERT INTO GRADES (Student_name) VALUES (?)";
     String select = "SELECT * FROM GRADES";
     String check = "SELECT * FROM GRADES WHERE Student_id = ? AND Student_name = ?";
     String updateQuery = "UPDATE GRADES SET MATHS=?, PHYSICS=?, CHEMISTRY=?, BIOLOGY=?, ENGLISH=? WHERE Student_id=? AND Student_name=?";
     String insertQuery = "INSERT INTO GRADES (Student_name, MATHS, PHYSICS, CHEMISTRY, BIOLOGY, ENGLISH) VALUES (?, ?, ?, ?, ?, ?)";
     String average = "SELECT AVG(MATHS) AS MATHS, " +
               "AVG(PHYSICS) AS PHYSICS, " +
               "AVG(CHEMISTRY) AS CHEMISTRY, " +
               "AVG(BIOLOGY) AS BIOLOGY, " +
               "AVG(ENGLISH) AS ENGLISH, " +
               "AVG(MATHS + PHYSICS + CHEMISTRY + BIOLOGY + ENGLISH) AS avg_total " +
               "FROM GRADES";
     String sumTotal = "UPDATE GRADES SET TOTAL_MARKS = ? WHERE Student_id = ?";
                    
}
