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

import se.TeacherDao.TeacherDaoimp;
import se.Teacherpojo.Teacher;
import se.studentDao.StudentDaoimp;
import se.studentpojo.Student;


@WebServlet("/addTeacher")
public class addTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name, int teacherId, String classAlloted, String parentMob, String photo
	String name =  request.getParameter("name");
	int teacherid=Integer.parseInt(request.getParameter("teacherid"));
	String classAlloted = request.getParameter("classAlloted");
	String gender =request.getParameter("gender");
	String mobno =request.getParameter("mobno");
	String emailid =request.getParameter("emailid");
	String password =request.getParameter("password");
  
	
	Teacher teacher = new Teacher( name,teacherid,classAlloted, gender,  emailid, mobno, password);
	System.out.println(teacher);
	
	TeacherDaoimp teacherDao = new TeacherDaoimp();
	int result = teacherDao.addTeacher(teacher);
	PrintWriter out=response.getWriter();
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("addTeacher.html");
	requestDispatcher.include(request, response);
	out.write("<script> alert('Teacher added succesfully')</script>");
	}
}
