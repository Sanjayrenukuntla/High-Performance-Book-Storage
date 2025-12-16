<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css"
</head>
<body>

    <div class="login">
       ${msg}
        <div class="loginbody">
            <img src="https://source.unsplash.com/300x300/?men" alt="profile" class="img">
            <form action="userLogin" method="post">
            <input type="text" name="userName" placeholder="Enter username" class="input"/>
            <input type="password" name="password" placeholder="Enter Password" class="input"/>
          
            <input type="submit" class="btn-dark" value="login"/>
           <a href="/register" class="register">Register</a>
        </form>
       
       
      
            
        </div>


    </div>
    
</body>
</html>