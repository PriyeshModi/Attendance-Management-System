<%@page import="se.studentpojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="se.studentDao.StudentDaoimp"%>
<%@page import="se.Teacherpojo.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="se.TeacherDao.TeacherDaoimp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height:100vh;background-image:linear-gradient(45deg,#cd3434,#f5a6d6,#e0dd71)">
<head>
<meta charset="ISO-8859-1">
<title>mark attendence</title>

<style>
table, th, td {
		border: 3px solid rgb(245, 243, 243);
       text-align: center;
       border-radius: 12px;
       background-color: rgb(237 ,153 ,149);
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
    #checkbox{
    width:31px;
    height:26px;
    }

</style>
</head>
<body>
<% int teacherid=Integer.parseInt(request.getParameter("teacherid"));
TeacherDaoimp teacherDaoimp= new TeacherDaoimp();
String clas=teacherDaoimp.teacheridToClass(teacherid);
      Cookie cookie =new Cookie("teacherid",teacherid+"");
      response.addCookie(cookie);
%>

 <h3>Class-><%=clas %></h3>
 
 <%
 StudentDaoimp studentdaoimp=new StudentDaoimp();
 List<Student> studentsList=studentdaoimp.getAllStudents(clas);
 
 %>
 	      <a href="teacherfunc.jsp?teacherid=<%= teacherid %>"><img style="width: 77px;height: 74px;border-radius:37px" src="png-clipart-computer-icons-back-icon-cdr-angle.png" alt="goback"></a> 
 
 <table>
		<caption>Students List</caption>
		<tr>
		
		    <th> mark attendence</th>
			<th>Roll number</th>
			<th>Name of theStudent</th>
			
			
		</tr>
		<form action="markAttendence" method="post">
		
		<% for(Student student: studentsList) {  %>
		<tr>
		    
		    <td><input id="checkbox" type="checkbox" name='<%= student.getRollno() %>'></td>
			<td><%= student.getRollno() %></td>
			<td><%= student.getName() %></td>
		
			
		</tr>
		<%} %>
	</table>
	
	<input style="width:99px;height:36px;margin-top:20px;font-size:20px;background-color:rgb(237 153 149);color:white;border-radius:7px;position:relative;left:48%" type="submit" value="submit"  >
	</form>
</body>
</html>