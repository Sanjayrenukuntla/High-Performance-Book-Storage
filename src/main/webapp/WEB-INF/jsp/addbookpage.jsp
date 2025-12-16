<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Add book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   
    <style type="text/css">

.login{
  text-align: center;
  width: 400px;
  margin: 60px auto;
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.input{
  width: 100%;
  padding: 14px;
  font-size: 16px;
  box-sizing: border-box;
  margin-bottom: 12px;
  border-radius: 10px;
  border: 1px solid lightgray;
}

.btn-dark{
  background-color: black;
  color: white;
  padding: 16px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-radius: 10px;
  font-size: 16px;
  margin-bottom: 20px;
}

.img{
height: 150px;
  border-radius: 50%;
}
.register{

  background-color: black;
  color: white;
  padding: 16px;
  border-radius: 10px;
  font-size: 16px;
}
.nav{
  background-color: lightgray;
  width: 100%;
  padding: 35px;
  margin-bottom: 50px;
}
.navbody{
  background-color: lightgray;
}

ul {
  text-decoration: none;
  list-style-type: none;

}
ul li{
  padding: 5px;
  float: left;
  
  
}

.active{
    background-color: red;
}

    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 25px;color: white;">
        <div class="container-fluid">
         
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/adminHome/${user.userName}">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/customers">View Customers</a>
              </li>
              <c:choose>
                <c:when test ="${update1 == 'update'}">
                    <li class="nav-item">
                        <a class="nav-link active" href="/addbookpage">update Books</a>
                      </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link active" href="/addbookpage">Add Books</a>
                      </li>
                </c:otherwise>
              </c:choose>
             
              <li class="nav-item">
                <a class="nav-link" href="/getAllBooksAdmin">view Books</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/adminOrders">View orders</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
              </li>
             
            </ul>
           
          </div>
        </div>
      </nav>
    <div class="login">
        <p>${msg}</p>


      
       
        <c:choose>
           
<c:when test ="${update1 == 'update'}">

<div class="loginbody">

    <form action="updateBook" method="post"  enctype="multipart/form-data">
        <input type="hidden" name="bookId" placeholder="Enter BookName" class="input" value="${book.bookId}" required/>   
    <input type="text" name="bookName" placeholder="Enter BookName" class="input" value="${book.bookName}" required/>
    <input type="text" name="bookIsn" placeholder="Enter BookIsn" class="input"  value="${book.bookIsn}" required/>
    <input type="text" name="authorName" placeholder="Enter Author Name" class="input" value="${book.authorModel.authorName}" required/>
    <input type="text" name="authorAddress" placeholder="Enter Author Address" class="input" value="${book.authorModel.authorAddress}" required/>
    <input type="text" name="publisherName"  placeholder="Enter publisher Name" class="input" value="${book.publisherModel.publisherName}" required/>
    <input type="text" name="publisherAddress"  placeholder="Enter publisher Address" class="input"  value="${book.publisherModel.publisherAddress}" required/>
    <input type="text" name="bookCost"  placeholder="Enter Book Cost" class="input" value="${book.publisherModel.bookCost}" required/>
   <!--  <input type="file" name="file" class="input"> -->
   
    <input type="submit" value="Update Book" class="btn-dark"/>
</form>

</div>

</c:when>
<c:otherwise>


<div class="loginbody">

    <form action="addBook" method="post"  enctype="multipart/form-data">
    <input type="text" name="bookName" placeholder="Enter BookName" class="input" required/>
    <input type="text" name="bookIsn" placeholder="Enter BookIsn" class="input" required/>
    <input type="text" name="authorName" placeholder="Enter Author Name" class="input" required/>
    <input type="text" name="authorAddress" placeholder="Enter Author Address" class="input" required/>
    <input type="text" name="publisherName"  placeholder="Enter publisher Name" class="input" required/>
    <input type="text" name="publisherAddress"  placeholder="Enter publisher Address" class="input" required/>
    <input type="text" name="bookCost"  placeholder="Enter Book Cost" class="input" required/>
    <input type="file" name="file" class="input">
   
    <input type="submit" value="ADD BOOk" class="btn-dark"/>
</form>

</div>

</c:otherwise>

        </c:choose>


    </div>
    
</body>
</html>