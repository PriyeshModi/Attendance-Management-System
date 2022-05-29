
<%@page import="se.studentpojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="se.studentDao.StudentDaoimp"%>
<%@page import="se.TeacherDao.TeacherDaoimp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height:100vh;background-image:linear-gradient(45deg,#d16d6d,#f5a6d6,#71c6e0)">

<meta charset="ISO-8859-1">
<title>Student Details</title>
<head>
<style>
	table, th, td {
		border: 3px solid rgb(245, 243, 243);
       text-align: center;
       border-radius: 12px;
       background-color: #99cdef;
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
TeacherDaoimp teacherdao =new TeacherDaoimp();
String clas= teacherdao.teacheridToClass(teacherid) ;
StudentDaoimp stddao=new StudentDaoimp();
List<Student> studentsList=stddao.getAllStudents(clas);


%>
	      <a href="teacherfunc.jsp?teacherid=<%= teacherid %>"><img style="width: 77px;height: 74px;border-radius:37px" src="png-clipart-computer-icons-back-icon-cdr-angle.png" alt="goback"></a> 

<h3>class-<%=clas %></h3>
	<table>
		<caption style="font-size:40px;color:black">Students List</caption>
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




</body>
</html>