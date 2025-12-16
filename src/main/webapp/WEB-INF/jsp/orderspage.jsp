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
                <a class="nav-link" href="/getAllBooks/${user.userName}">View Books</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/cart/${user.userName}" style="text-align: end; position: fixed;right: 25px;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                    <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5M3.14 5l.5 2H5V5zM6 5v2h2V5zm3 0v2h2V5zm3 0v2h1.36l.5-2zm1.11 3H12v2h.61zM11 8H9v2h2zM8 8H6v2h2zM5 8H3.89l.5 2H5zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0m9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0"/>
                  </svg>&nbsp;<span>${cartItems}</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/getOrderdBooks/${user.userName}">Ordered Books</a>
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
    <h4>${cartmsg}</h4>
    <h3 style="text-align: center;">Your Orders</h3>
    <h4 style="color: red;">${msg}</h4>
    <div class="row">

        
        <c:forEach items="${orders}" var="element">
       
      <div class="col-3 bookview" style="margin-top: 10px;" >
        <c:forEach items="${element.listofBooks}" var="element2">
        <img src="/images/${element2.bookUrl}" class="img" alt="img">
        </c:forEach>
      
        <p>Order Id: ${element.orderId}</p>
        <p>Ordered Date:${element.orderedDate}</p>
        <p>Ordered Status: <span style="font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;font-size: 16px;">${element.orderStatus}</span></p>
        <c:forEach items="${element.listofBooks}" var="element1">
            <div style="border-top: 2px solid lightgray;">
            <p>Book Name: ${element1.bookName}</p>
            <p>Book Author: ${element1.authorModel.authorName}</p>
            <p>Book Url: ${element1.bookUrl}</p>
        </div>
        </c:forEach>
    </hr>

    <c:choose>
  <c:when test = "${element.orderStatus == 'cancelled'}">
<p style="color: red;"> order is cancelled</p>
<p style="color: red;"> Waiting for refund</p>
      </c:when>
      <c:when test = "${element.orderStatus == 'refund'}">
        <p style="color: red;"> Amount has been refunded</p>
              </c:when>
              <c:when test = "${element.orderStatus == 'shipped'}">
                <p style="color: red;">Your Order has been Shipped you will receive your order soon</p>
                      </c:when>    
      <c:otherwise>
        <c:choose>
         
        <c:when test = "${empty orders}">
       <p>No orders</p>
        </c:when>
        <c:otherwise>
           <form action="/cancelOrder" method="post">
               <input type="hidden" value="${element.orderId}" name="orderid"/>
               <input type="hidden" value="${element.userId}" name="userId"/>
               <input type="submit" value="Cancel the order" class="btn btn-danger" style="margin: 20px 20px; padding: 20px 20px"/> 
           </form> 
           
        </c:otherwise>
     </c:choose>

      </c:otherwise>
    </c:choose>
  
      </div>
     
   
      <div 
     
     
    </c:forEach>
    </div>
   
   
</div>

  


    </div>
    
</body>
</html>