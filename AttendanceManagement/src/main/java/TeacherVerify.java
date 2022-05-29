

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

/**
 * Servlet implementation class TeacherVerify
 */
@WebServlet("/teacherVerify")
public class TeacherVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherid=request.getParameter("teacherid");
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
		
			System.out.println(teacherid);
			System.out.println(password);
	
		
         String query="select teacherid,password from teachers where teacherid='"+teacherid+"' and password='"+password+"'";
        
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
					
					 response.sendRedirect("teacherfunc.jsp?teacherid="+teacherid);
				  }
				else {
					PrintWriter out = response.getWriter();
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacherlogin.html");
					requestDispatcher.include(request, response);
					out.print("<p style='color:red;position:absolute;left:42%;top:62%;font-size:19px'>Wrong username or password. </p><br/><br/>");}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

}
