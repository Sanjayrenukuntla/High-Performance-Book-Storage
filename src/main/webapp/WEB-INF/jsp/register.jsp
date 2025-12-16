<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Register</title>
</head>
<body>
    <div class="login">
        <p>${msg}</p>
<div class="loginbody">

    <form action="userRegister" method="post">
    <input type="text" name="userName" placeholder="Enter username" class="input" required/>
    <input type="password" name="password" placeholder="Enter Password" class="input" required/>
    <input type="password" name="password" placeholder="Conform Password" class="input" required/>
    <input type="text" name="emailId" placeholder="Enter EmailId" class="input" required/>
    <input type="text" name="phoneNubmer" placeholder="Enter mobile number" class="input" required/>
    <input type="text" name="address"  placeholder="Enter address" class="input" required/>
    <select class="input" name="userType">
        <option>User</option>
        <option>Admin</option>
    </select>
    <input type="submit" value="REGISTER" class="btn-dark"/>
</form>

</div>

    </div>
    
</body>
</html>