package se.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.studentDao.StudentDaoimp;
import se.studentpojo.Student;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		String clas=request.getParameter("class");
		 String parentMob=request.getParameter("parentMob");
		 String address=request.getParameter("address");
		 String gender=request.getParameter("gender");
		 int attendence=0;
		String password=request.getParameter("password");
		int total_attendence=Integer.parseInt(request.getParameter("password"));
		Student student = new Student(name, rollno,clas, parentMob, address, gender,  password,attendence,total_attendence);
		System.out.println(student);
		
		StudentDaoimp studentDao = new StudentDaoimp();
		int result = studentDao.addStudent(student);
		
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("addStudent.html");
		requestDispatcher.include(request, response);
		out.write("<script> alert('Student added succesfully')</script>");
		
		
	}

}
