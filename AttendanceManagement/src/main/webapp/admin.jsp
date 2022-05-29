<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en" style="height:100vh;background-image:linear-gradient(45deg,#4bff4b,#6565ff,#e08ae0)">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Admin Login</title>
</head>
<body>
    <h1 style="position: absolute;left: 45%;top:29%">Admin login</h1>
    <div id="form">
    <form  action="adminverify" method="post">
        <label style="font-size: 20px;">Enter username</label>
        <input type="text" name="admin_username" id="username" ><br>
        <label style="font-size: 20px;" >Enter password</label>
        <input type="password" name="admin_password" id="password" ><br>
        <input  style="border-radius:8px;width: 112px;height: 34px;font-size: 17px;    margin-left: 82px; margin-top: 21px;" type="submit" value="submit">
    </form>
    
    
      
</div>
</body>
</html>
    
    
    
      
</div>
</body>
</html>