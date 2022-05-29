<%@page import="se.studentpojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="se.studentDao.StudentDaoimp"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html style="height:100vh;background-image: linear-gradient(45deg,green,white);background-size: cover;">
<head >
<meta charset="ISO-8859-1">
<title>Students List</title>
<style>
	table, th, td {
		border: 3px solid rgb(245, 243, 243);
       text-align: center;
       border-radius: 12px;
       background-color: rgb(169, 219, 159);
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
        font-size: 40px;
        text-decoration: crimson underline;
		margin-bottom: 40px;
		 color:crimson;
	}
    h3 {
        color:crimson;
        position: absolute;
        font-size: 25px;
		top:10px;
        left: 48%;
        text-decoration: crimson underline;
		margin-bottom: 40px;
	}
    table{
        margin-top:10%;
    }
</style>
</head>
<body>
   
	<% 
     String clas=request.getParameter("class");
	StudentDaoimp studentDao = new StudentDaoimp();
		List<Student> studentsList = studentDao.getAllStudents(clas);
	%>
	      <a href="../adminfunc.html"><img style="width: 77px;height: 74px;border-radius:37px" src="../png-clipart-computer-icons-back-icon-cdr-angle.png" alt="goback"></a> 
	
	<h3>class-<%=clas %></h3>
	<table>
		<caption>Students List</caption>
		<tr>
			<th>Roll number</th>
			<th>Name of theStudent</th>
			<th>Parent's Contact no.</th>
			<th>Address</th>
			<th>Gender</th>
		</tr>
		
		<% for(Student student: studentsList) {  %>
		<tr>
			<td><%= student.getRollno() %></td>
			<td><%= student.getName() %></td>
			<td><%= student.getParentMob() %></td>
			<td><%= student.getAddress() %></td>
			<td><%= student.getGender() %></td>
			
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
	
	<p style="position:relative;left:47%;top:15%;width:97px;text-align: center;background-color:#34cd55;color:white;font-size:18px;
	padding:6px;border-radius:6px;text-decoration:none;"><a href="../addStudent.html">Add Student</a></p>

</body>
</html>