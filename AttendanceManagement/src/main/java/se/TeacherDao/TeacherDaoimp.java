package se.TeacherDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import se.Teacherpojo.Teacher;
import se.studentpojo.Student;

public class TeacherDaoimp {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/school";
	private final static String USER = "root";
	private final static String PWD = "1234";

	private Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PWD);
		return con;}
	
	
	
	public int addTeacher(Teacher teacher) {
		int result = 0;

		try(Connection con = getConnection();
				PreparedStatement pStmt = con.prepareStatement("INSERT INTO teachers (teacherid,name,class_alloted, mobno, gender, emailid,password) VALUES (?,?,?,?,?,?,?)")){
			pStmt.setInt(1, teacher.getTeacherId());
			pStmt.setString(2, teacher.getName());
			pStmt.setString(3, teacher.getClassAlloted());
			pStmt.setString(5, teacher.getGender());
			pStmt.setString(6, teacher.getEmailId());
			pStmt.setString(4, teacher.getMobno());
			pStmt.setString(7, teacher.getPassword());
			result = pStmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
        public List<Teacher> getAllTeachers() {
		
		List<Teacher> teachersList = new ArrayList<Teacher>();
		
		try(
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rSet = stmt.executeQuery("SELECT * FROM teachers");
				){

			while(rSet.next()) {
				int teacherId=rSet.getInt("teacherid");
				String name = rSet.getString("name");
				String classAlloted = rSet.getString("class_alloted");
				String gender= rSet.getString("gender");
				String emailId= rSet.getString("emailid");
			String mobno = rSet.getString("mobno");
			String password = rSet.getString("password");
			
				teachersList.add(new Teacher( name,teacherId,classAlloted, gender,  emailId, mobno, password));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teachersList;
	}
        public String teacheridToClass (int teacherid) {
            String clas=null;
  		try(
  				Connection con = getConnection();
  				Statement stmt = con.createStatement();
  				ResultSet rSet = stmt.executeQuery("SELECT class_alloted FROM teachers where teacherid='"+teacherid+"'");
  				){

  			while(rSet.next()) {
  				
  				clas = rSet.getString("class_alloted");
  				System.out.println(clas);
  				
  			}
  			
  		} catch (ClassNotFoundException e) {
  			e.printStackTrace();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		
  		return clas;
  	}
   	   

}
