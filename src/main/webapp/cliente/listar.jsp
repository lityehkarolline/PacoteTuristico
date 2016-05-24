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
			<h1>Clientes</h1>
		</div>

		<div class="row">

			<div class="col-sm-2">
				<form class="navbar-form"
					action="<%=request.getContextPath()%>/cliente/novo">
					<button type="submit" class="btn btn-primary">Inserir novo</button>
				</form>
			</div>

			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/cliente/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um nome" class="form-control" />
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>

		</div>

		<table class="table">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Fone</th>
					<th>CPF</th>
					<th>Nascimento</th>
					<th>RendaMensal</th>
					<th>A��o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCliente}</td>
						<td>${x.nome}</td>
						<td>${x.email}</td>
						<td>${x.telefone}</td>
						<td>${x.cpf}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
								value="${x.nascimento}" /></td>
						<td><fmt:setLocale value="pt_br" />
							<fmt:formatNumber type="currency" value="${x.rendaMensal}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/cliente/editar?cod=${x.codCliente}"
							class="btn btn-primary btn-xs">Editar</a> <a
							href="<%=request.getContextPath()%>/cliente/remover?cod=${x.codCliente}"
							class="btn btn-danger btn-xs">Excluir</a></td>
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