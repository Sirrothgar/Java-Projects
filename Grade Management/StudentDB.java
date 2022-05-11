
import java.sql.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brothrock
 */
public class StudentDB {
    //contrants

    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/cis335a";
    private final String USER_NAME = "root";
    private final String PASSWORD = "andzarrian";

    //behaviors
    // save a student object to the database
    public void add(Student stu) throws ClassNotFoundException, SQLException {
        /* ALWAYS use PreparedStatement to write to databases when we get input from users
        to help prevent hacking. Injection attacks are very common against databases.
        http://sqlzoo.net/hack
         */

        // check for the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);

        // write the student record to the database
        String sqlStr = "INSERT INTO Students (student_name, Test1, Test2, Test3) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlStr);
        pstmt.setString(1, stu.getName());
        pstmt.setDouble(2, stu.getTest1());
        pstmt.setDouble(3, stu.getTest2());
        pstmt.setDouble(4, stu.getTest3());

        pstmt.execute();

        // close the connection
        conn.close();
    }

    public ArrayList<Student> getAll() throws ClassNotFoundException, SQLException {
        // create an empty ArrayList
        ArrayList<Student> list = new ArrayList<Student>();

        //check for the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // get the records from the database
        String strSQL = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);
        
        while(rs.next())
        {
            int stuID = rs.getInt(1);
            String name = rs.getString(2);
            double test1 = rs.getDouble(3);
            double test2 = rs.getDouble(4);
            double test3 = rs.getDouble(5);
            
            Student stu = new Student(stuID, name, test1, test2, test3);
            
            list.add(stu);
        }
        
        //close the connection to the database
        conn.close();
        
        //return the ArrayList 
        return list;
    }
}
