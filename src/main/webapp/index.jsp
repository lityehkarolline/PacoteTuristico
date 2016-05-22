<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sistema Pacotes Turisticos</title>

    <link href="<%request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">

  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%request.getContextPath()%>/">Sistema Pacotes Turisticos</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
   
            <li><a href="<%request.getContextPath()%>/cliente/listar">Cadastro de Cliente</a></li>
            <li><a href="<%request.getContextPath()%>/hoteis/pesquisar">Pesquisar Hotéis</a></li>
            <li><a href="<%request.getContextPath()%>/item/hotel">Incluir Item em Pacote</a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Sticky footer with fixed navbar</h1>
      </div>
      <p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS. A fixed navbar has been added with <code>padding-top: 60px;</code> on the <code>body > .container</code>.</p>
      <p>Back to <a href="../sticky-footer">the default sticky footer</a> minus the navbar.</p>
    </div>

    <footer class="footer">
      <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
      </div>
    </footer>

    
    <!-- Core JS -->
    <script src="<%request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>