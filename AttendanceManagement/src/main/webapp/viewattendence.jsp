<%@page import="se.studentpojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="se.studentDao.StudentDaoimp"%>
<%@page import="se.TeacherDao.TeacherDaoimp"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Attendence</title>
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
        position: absolute;
		top:130px;
       left:23%;
		border-collapse: collapse;
	}
	
	h3 {
        color:crimson;
        position: absolute;
        font-size: 36px;
		top:10px;
        left: 43%;
        text-decoration: crimson underline;
		margin-bottom: 40px;
	}
</style>
</head>
<body>
	<% 
	 int teacherid=Integer.parseInt(request.getParameter("teacherid"));
	TeacherDaoimp teacherDaoimp= new TeacherDaoimp();
	String clas=teacherDaoimp.teacheridToClass(teacherid);
     
	StudentDaoimp studentDao = new StudentDaoimp();
		List<Student> studentsList = studentDao.getAllStudents(clas);
	%>
	      <a href="teacherfunc.jsp?teacherid=<%= teacherid %>"><img style="width: 77px;height: 74px;border-radius:37px" src="png-clipart-computer-icons-back-icon-cdr-angle.png" alt="goback"></a> 
	
	<h3>Attendence</h3>
	<table>
		
		<tr>
			<th>Roll number</th>
			<th>Name of theStudent</th>
			<th style=" background-color: rgb(169, 219, 159)">Attendence(%)</th>
			
		</tr>
		
		<% for(Student student: studentsList) {  %>
		<tr>
			<td><%= student.getRollno() %></td>
			<td><%= student.getName() %></td>
			<%
		     int  a=student.getAttendence();
			 int b=student.getTotal_attendence();
			 
			  int c=(a*100)/b;
			%>
			<td class="attendence"  style="color:white; background-color: rgb(169, 219, 159)"><%= c %></td>
			
			
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
	<script>
	let a=document.getElementsByClassName("attendence");
    console.log(a);
        for(var x=0;x<a.length;x++)
          if(a[x].innerHTML>75){
              a[x].style.backgroundColor="green";
          }
          else{
           a[x].style.backgroundColor="red";
          }
	
	</script>
	

</body>
</html>