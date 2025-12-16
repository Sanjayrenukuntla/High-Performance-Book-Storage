<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <style type="text/css">
        .bookview{    
   padding: 5px 5px;
    border: 1px solid lightgray;
    border-radius: 10px;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    margin-left: 5px;
        }
      .img{
        width: 100%;

      }  
      p{
        font-family: 14px;
        font-weight: 500;
        font-style: normal;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
      }
      .flexView{
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
      }
      .active{
        background-color: red;

      }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>UserHomePage</title>
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
              <li class="nav-item">
                <a class="nav-link" href="/addbookpage">Add Books</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/getAllBooksAdmin">view Books</a>
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
   

   <div class="container">
    <h3>welcome ${user.userName}</h3>
    <h4 style="color: red;">${cartmsg}</h4>
    <div class="row">
        <c:forEach items="${books}" var="element">
       
      <div class="col-3 bookview" style="margin-top: 10px;" >
        <img src="/images/${element.bookUrl}" class="img" alt="image">
        <p>Book Id: ${element.bookId}</p>
        <p>Book Name: ${element.bookName}</p>
        <p>Book IsN :${element.bookIsn}</p>
        <p>Author Name : ${element.authorModel.authorName}</p>
        <p>Publisher Name : ${element.publisherModel.publisherName}</p>
        <div>
            <div class="row">
                <div class="col-6">
            <form action="/Editbookpage" method="post">
              <input type="hidden" name="bookId" value="${element.bookId}"/>
            <input type="submit" value="Edit Book" class="btn btn-success">
        </form>
    </div>
    <div class="col-6">
        <form action="/deleteBook" method="post">
          <input type="hidden" name="bookId" value="${element.bookId}"/>
        <input type="submit" value="Delete Book" class="btn btn-danger">
    </form>
</div>
</div>
        </div>
      </div>
     
   
      <div 
     
    </c:forEach>
    </div>

   </div>

    


    </div>
    
</body>
</html>