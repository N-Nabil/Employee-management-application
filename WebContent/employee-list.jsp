<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #343a40;">
			<div>
				<a href="#" class="navbar-brand">Gestion des employés </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employés</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste des employés</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter un employé</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>CIN</th>
						<th>Type contrat</th>
						<th>Sexe</th>
						<th>Poste</th>
						<th>Email</th>
						<th>TEL</th>
						<th>Date naissance</th>
						<th>Date entree</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="emp" items="${listEmployee}">
						<tr>
							<td><c:out value="${emp.id}" /></td>
							<td><c:out value="${emp.nom}" /></td>
							<td><c:out value="${emp.prenom}" /></td>
							<td><c:out value="${emp.cin}" /></td>
							<td><c:out value="${emp.type_contrat}" /></td>
							<td><c:out value="${emp.sexe}" /></td>
							<td><c:out value="${emp.poste}" /></td>
							<td><c:out value="${emp.email}" /></td>
							<td><c:out value="${emp.num_tel}" /></td>
							<td><c:out value="${emp.date_naissance}" /></td>
							<td><c:out value="${emp.date_entree}" /></td>
							<td><a href="edit?id=<c:out value='${emp.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${emp.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>							