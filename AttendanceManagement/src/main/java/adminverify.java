

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminverify")
public class adminverify extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("admin_username");
		String password=request.getParameter("admin_password");
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
		
			System.out.println(username);
			System.out.println(password);
	
		
         String query="select username,password from admin where username='"+username+"' and password='"+password+"'";
        
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
					
					 response.sendRedirect("adminfunc.html");
				  }
				else {
					PrintWriter out = response.getWriter();
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
					requestDispatcher.include(request, response);
					out.print("<p style='color:red;position:absolute;left:42%;top:62%;font-size:19px'>Wrong username or password. </p><br/><br/>");}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
      
	}

}
