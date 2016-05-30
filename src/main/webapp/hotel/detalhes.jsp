<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Pacotes Turisticos</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes do hotel</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codHotel}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Cidade: ${item.cidade}</li>
				<li class="list-group-item">Diaria: ${item.diaria}</li>
			</ul>
		</div>

		<div>
			<a href="<%=request.getContextPath()%>/hotel/pesquisar"
				class="btn btn-success">Nova Pesquisa</a>
		</div>
		
		<div class="page-header">
			<h1>Pacotes do ${item.nome}</h1>
		</div>
		
		<table class="table">
			<thead>
			
				<tr>
					<th>Nome: </th>
					<th>Preço Total do Pacote: </th>
				</tr>
				
			</thead>
			<tbody>
		
				<c:forEach items="${item.pacotes}" var="x">
					<tr>
						<td>${x.nome}</td>
						<td>${x.precoTotal}</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
	</div>

		

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>