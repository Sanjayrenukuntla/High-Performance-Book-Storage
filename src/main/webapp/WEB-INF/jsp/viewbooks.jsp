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
                <a class="nav-link" aria-current="page" href="/homepage/${user.userName}">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/getAllBooks/${user.userName}">View Books</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/cart/${user.userName}" style="text-align: end; position: fixed;right: 25px;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                    <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5M3.14 5l.5 2H5V5zM6 5v2h2V5zm3 0v2h2V5zm3 0v2h1.36l.5-2zm1.11 3H12v2h.61zM11 8H9v2h2zM8 8H6v2h2zM5 8H3.89l.5 2H5zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0m9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0"/>
                  </svg>&nbsp;<span>${cartItems}</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/getOrderdBooks/${user.userName}">Orderd Books</a>
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
        <p style="color: rgb(237, 14, 14);font-size: 16px;">Book Cost : ${element.publisherModel.bookCost}</p>
        <p>Book Name: ${element.bookName}</p>
        <p>Book IsN :${element.bookIsn}</p>
        <p>Author Name : ${element.authorModel.authorName}</p>
        <p>Publisher Name : ${element.publisherModel.publisherName}</p>
        <div>
            <form action="/addTocart" method="post">
                <input type="hidden" name="userName" value="${user.userName}"/>
              <input type="hidden" name="bookId" value="${element.bookId}"/>
            <input type="submit" value="Add to cart" class="btn btn-success">
        </form>
        </div>
      </div>
     
   
      <div 
     
    </c:forEach>
    </div>

   </div>

    


    </div>
    
</body>
</html>