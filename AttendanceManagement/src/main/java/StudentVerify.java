

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studentVerify")
public class StudentVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rollno=request.getParameter("rollno");
		String password=request.getParameter("password");
		Connection con = null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
       
			 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println(rollno);
			System.out.println(password);
	
		
         String query="select * from students where rollno='"+rollno+"' and password='"+password+"'";
        
			 try {
				stm=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
		      ResultSet rset = null;
			try {
				rset = stm.executeQuery(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      try {
				if(rset.next())
				  {
					String name=rset.getString("name");
					int attendence=rset.getInt("attendence");
					int total_attendence=rset.getInt("Total_attendence");
					int roll=Integer.parseInt(rollno);
					System.out.println(name);
					System.out.println(attendence);
					System.out.println(total_attendence);
					System.out.println(roll);
					 response.sendRedirect("StudentAttendence.jsp?name="+name+"&attendence="+attendence+"&total_attendence="+total_attendence+"&rollno="+roll);
				  }
				else {
					PrintWriter out = response.getWriter();
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentlogin.html");
					requestDispatcher.include(request, response);
					out.print("<p style='color:red;position:absolute;left:42%;top:62%;font-size:19px'>Wrong username or password. </p><br/><br/>");}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	}

}
