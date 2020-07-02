<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photobreak</title>
<!-- Bootstrap core CSS -->
 <link href="login-util/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
  <br>
  </div>
  <div class="container">
  <header>
   <h1>Lista De Usuarios Sistema Photobreak</h1>
  </header>
  <div class="starter-template">
  
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>Id</th>
     <th>Email</th>
     <th>Nome</th>
     <th>Telefone</th>
    </tr>
    <c:forEach var="user" items="${login}">
     <tr>
      <td>${user.id}</td>
      <td>${user.email}</td>
      <td>${user.nome}</td>
      <td>${user.telefone}</td>
     </tr>
    </c:forEach>
   </table>
  </div>
 </div>
  
<!-- Bootstrap core JavaScript -->
  <script src="login-util/vendor/jquery/jquery.slim.min.js"></script>
  <script src="login-util/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>