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
                <a class="nav-link" href="/getAllBooksAdmin">view Books</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/adminOrders">View orders</a>
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
    <h4 style="color: red;">${msg}</h4>
    <div class="row">

        
        <c:forEach items="${orders}" var="element">
       
      <div class="col-3 bookview" style="margin-top: 10px;" >
       
      
        <p>Order Id: ${element.orderId}</p>
        <p>Ordered Date:${element.orderedDate}</p>
        <p>Ordered Status:${element.orderStatus}</p>
        <c:forEach items="${element.listofBooks}" var="element1">
            <div style="border-top: 2px solid lightgray;">
            <p>Book Name: ${element1.bookName}</p>
            <p>Book Author: ${element1.authorModel.authorName}</p>
        </div>
        </c:forEach>
    </hr>
    <c:choose>
     
        <c:when test = "${element.orderStatus == 'cancelled'}">
            <h3>Order is cancelled by User</h3>
            <form action="/updateRefund" method="post">
                <input type="hidden" value="${element.orderId}" name="orderId"/>
                
                <input type="submit" value="refund " class="btn btn-danger" style="margin: 20px 20px; padding: 20px 20px"/> 
            </form> 

        </c:when>

        <c:when test = "${element.orderStatus == 'refund'}">
            <h3>Refunded to User</h3>

        </c:when>
        <c:when test = "${element.orderStatus == 'shipped'}">
            <h3>Order has been shipped to user</h3>

        </c:when>
        <c:otherwise>

        <c:choose>
         
        <c:when test = "${empty orders}">
       <p>No orders</p>
        </c:when>
        <c:otherwise>
           <form action="/shipTheOrder" method="post">
            <input type="hidden" value="${element.orderId}" name="orderId"/>
               
               <input type="submit" value="Ship the order" class="btn btn-primary" style="margin: 20px 20px; padding: 15px 15px"/> 
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