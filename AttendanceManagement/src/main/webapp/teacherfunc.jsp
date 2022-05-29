<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="se2.css">
    
</head>
<body >
       <% 
         int teacherid=Integer.parseInt(request.getParameter("teacherid"));
         
       %>
    
     <a href="firstpage.html"><p style="margin:2%;text-align:center;width: 77px;height: 28px;text-decoration:red underline;color:white; background-color:red">Log out</p>
    <div > 
    <a href="markattendence.jsp?teacherid=<%=teacherid%>"><img id="img" style="width: 95%;height: 254px;" src="attendance-icon-16.jpg" alt="teacher"></a>
    <a href="viewattendence.jsp?teacherid=<%=teacherid%>"><img id="img" style="width: 90%;height: 254px;" src="2123.png" alt="view students"></a>
    <a href="StudentDetails.jsp?teacherid=<%=teacherid%>"><img id="img" style="width: 97%;height: 254px;" src="id-icon-16.jpg" alt="teacher"></a>
    </div>
    
     <p style="background-color:#7e7f82;position:absolute;left:23%;top:66%">Mark Attendence</p>
      <p style="background-color:#7e7f82;position:absolute;left:51%;top:66%">Attendence</p>
       <p style="background-color:#7e7f82;position:absolute;left:77%;top:66%">Student Details</p>
</body>
</html>