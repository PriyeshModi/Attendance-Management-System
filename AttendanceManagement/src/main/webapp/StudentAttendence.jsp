<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height:100vh;background-image:linear-gradient(45deg,#39cf60,#dce796,#96da3d)" >
<head>
<meta charset="ISO-8859-1">
<title>Student Attendence</title>

</head>
<body>
<% 

String name=request.getParameter("name");
int attendence=Integer.parseInt(request.getParameter("attendence"));
int Total_attendence=Integer.parseInt(request.getParameter("total_attendence"));
int rollno=Integer.parseInt(request.getParameter("rollno"));
  %>
       <a href="firstpage.html"><p style="font-size:24px;border-radius:6px;margin:2%;text-align:center;width: 93px;height: 35px;text-decoration:red underline;color:white; background-color:red">Log out</p>
  </a>
  <h3 style="position: relative;left: 46%;font-size: 35px;">Attendence</h3>
	<table style="margin:0 auto;width:65%;height:150px">
		
		<tr>
			<th style="color:white;font-size:21px; border: 3px white;text-align: center;border-radius: 4px;background-color: #27d755;border: 3px white;">Roll number</th>
			<th style="color:white;font-size:21px; border: 3px white;text-align: center;border-radius: 4px;background-color: #27d755;border: 3px white;">Name of theStudent</th>
			<th style="color:white;font-size:21px;border: 3px white;text-align: center;border-radius: 4px; background-color: #27d755;border: 3px white;">Attendence(%)</th>
			
		</tr>
		
			<tr>
			<td  style="color:white;font-size:21px; border: 3px white;text-align: center;border-radius: 4px;background-color: #27d755;border: 4px white;"><%= rollno %></td>
			<td style="color:white; font-size:21px;border: 3px white;text-align: center;border-radius: 4px;background-color: #27d755;border: 4px white;"><%= name %></td>
			<%
		     int  a=attendence;
			 int b=Total_attendence;
			 
			  int c=(a*100)/b;
			%>
			<td class="attendence"  style="color:white;font-size:21px;border: 3px white;text-align: center;border-radius: 4px;color:white; background-color: rgb(169, 219, 159)"><%= c %></td>
			
			
		</tr>
		
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
	var a=document.getElementsByClassName("attendence");
    
       
          if(a.innerHTML>75){
              a.style.backgroundColor="rgb(126 249 102)";
          }
          else{
           a.style.backgroundColor="red";
          }
	
	</script>
	

</body>
</html>
  
  
</body>
</html>