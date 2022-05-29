package se.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/markAttendence")
public class MarkAttendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/school";
	private final static String USER = "root";
	private final static String PWD = "1234";
	private Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PWD);
		return con;
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		
		int teacherid=0;
		if(cookies==null) {
			System.out.println("no cookies");
		} else {
			for(Cookie c : cookies) {
				String key = c.getName();
				if(key.equals("teacherid")) {
				   teacherid = Integer.parseInt(c.getValue());
				} else {
					System.out.println("no value of cookie");

				}}
		Enumeration<String> names= request.getParameterNames();
		System.out.println("inside");
		String a;
		try {
		while(( a=names.nextElement())!=null) {
			Connection con = getConnection();
			System.out.println(a);
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery("SELECT attendence FROM students where rollno="+a);
		while(rSet.next()) {
			
		  int attendence = Integer.parseInt(rSet.getString("attendence"));
			System.out.println(attendence);
			attendence=attendence+1;
			System.out.println(attendence);
			System.out.println(attendence);
			try{Connection con2 = getConnection();
					
					PreparedStatement pStmt = con2.prepareStatement("update students set attendence="+attendence+" where rollno="+a);
				
					int result = pStmt.executeUpdate();
				
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}}catch(Exception e) {
			
		}
		

		Connection con3 = null;
		try {
			con3 = getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Statement stmt3 = null;
		try {
			stmt3 = con3.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rSet3 = null;
		try {
			rSet3 = stmt3.executeQuery("SELECT rollno,Total_attendence FROM students");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	try {
		while(rSet3.next()) {
			int roll=Integer.parseInt(rSet3.getString("rollno"));
		  int total_attendence = Integer.parseInt(rSet3.getString("Total_attendence"));
			System.out.println(total_attendence);
			total_attendence=total_attendence+1;
			System.out.println(total_attendence);
			
			try{Connection con2 = getConnection();
					
					PreparedStatement pStmt = con2.prepareStatement("update students set Total_attendence="+total_attendence+" where rollno="+roll);
				
					int result = pStmt.executeUpdate();
				
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} catch (NumberFormatException e) {
	
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
		
		
		
		
		
		PrintWriter out=response.getWriter();
		
		out.write("<script> alert('Attendence marked successfully')</script>");
		RequestDispatcher rq=request.getRequestDispatcher("teacherfunc.jsp?teacherid="+teacherid);
		 rq.include(request, response);
		 
		
	}

}}
