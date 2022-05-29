<%@page import="se.Teacherpojo.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="se.TeacherDao.TeacherDaoimp"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background-image:url('../wp2894099-plain-blue-wallpapers.jpg');background-size:cover;height:100vh">
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
<style>
	table, th, td {
		border: 3px solid rgb(245, 243, 243);
       text-align: center;
       border-radius: 12px;
        background-color: rgb(71, 173, 204);
	}
	th{
        border-radius: 12px;
    }
	table {
		width: 50%;
        height: 20vh;
		margin:auto;
        font-size: 18px;
      
		border-collapse: collapse;
	}
	
	caption {
        position: absolute;
		top:90px;
        left: 45%;
        color:rgb(40, 93, 192);
        font-size: 40px;
        text-decoration: rgb(40, 93, 192) underline;
		margin-bottom: 40px;
	}
   
    table{
        margin-top:10%;
    }
</style>
</head>
<body >
	<% 
  
	TeacherDaoimp studentDao = new TeacherDaoimp();
		List<Teacher> teachersList = studentDao.getAllTeachers();
	%>
	
	<table>
		<caption>Teachers List</caption>
		<tr>
			<th>Teacher ID</th>
			<th>Name of the Teacher</th>
			<th>Contact Number</th>
			<th>Email ID</th>
			<th>Gender</th>
			<th>Class Alloted</th>
		</tr>
		
		<% for(Teacher teacher: teachersList) {  %>
		<tr>
			<td><%= teacher.getTeacherId() %></td>
			<td><%= teacher.getName() %></td>
			<td><%= teacher.getMobno() %></td>
			<td><%= teacher.getEmailId() %></td>
			<td><%= teacher.getGender() %></td>
			<td><%= teacher.getClassAlloted()%></td>
			
		</tr>
		<%} %>
	</table>
	
	<p>
	
	<% 
		String message = request.getParameter("message");
		if(message!=null) {
			out.print(message);		
		}
	
	%>
	
	</p>
	
	<p style="position:relative;left:47%;top:15%;width:97px;text-align: center;background-color:#4aa2ebea;color:white;font-size:18px;
	padding:6px;border-radius:6px;text-decoration:none;"><a href="../addTeacher.html">Add Teacher</a></p>

</body>
</html>