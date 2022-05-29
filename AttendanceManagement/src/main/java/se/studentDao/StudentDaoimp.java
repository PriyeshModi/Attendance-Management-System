package se.studentDao;
import se.studentpojo.Student;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoimp {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/school";
	private final static String USER = "root";
	private final static String PWD = "1234";

	private Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PWD);
		return con;}
	
	
	
	public int addStudent(Student student) {
		int result = 0;

		try(Connection con = getConnection();
				PreparedStatement pStmt = con.prepareStatement("INSERT INTO students (rollno,name,class,parent_mob,address,gender,password,attendence,Total_attendence) VALUES (?,?,?,?,?,?,?,?,?)")){
			
			pStmt.setString(2, student.getName());
			pStmt.setInt(1, student.getRollno());
			pStmt.setString(3, student.getClas());
			pStmt.setString(4, student.getParentMob());
			pStmt.setString(5, student.getAddress());
			pStmt.setString(6, student.getGender());
			pStmt.setString(7, student.getPassword());
			pStmt.setInt(8, student.getAttendence());
			pStmt.setInt(9, 0);
			result = pStmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
        public List<Student> getAllStudents(String clas) {
		
		List<Student> studentsList = new ArrayList<Student>();
		
		try(
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rSet = stmt.executeQuery("SELECT * FROM students where class='"+clas+"'"+"ORDER BY rollno");
				){

			while(rSet.next()) {
				
				String name = rSet.getString("name");
				int rollno = rSet.getInt("rollno");
				String clas2=rSet.getString("class");
				String address=rSet.getString("address");
			String parentMob = rSet.getString("parent_mob");
			String gender=rSet.getString("gender");
			String password=rSet.getString("password");
			int attendence=rSet.getInt("attendence");
				int total_attendence=rSet.getInt("Total_attendence");
				studentsList.add(new Student(name, rollno,clas2, parentMob, address, gender,  password,attendence,total_attendence));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentsList;
	}
      
    	   
    	   
       }


