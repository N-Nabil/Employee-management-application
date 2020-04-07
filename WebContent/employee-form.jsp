<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<a href="#" class="navbar-brand"> Gestion des employés </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employés</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
            			Modifier un Employé
            		</c:if>
						<c:if test="${emp == null}">
            			Ajouter un Employé
            		</c:if>
					</h2>
				</caption>

				<c:if test="${emp != null}">
					<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${emp.nom}' />" class="form-control"
						name="nom" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>Prenom</label> <input type="text"
						value="<c:out value='${emp.prenom}' />" class="form-control"
						name="prenom" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>CIN</label> <input type="text"
						value="<c:out value='${emp.cin}' />" class="form-control"
						name="cin" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>Type Contrat</label> 
					<select value="<c:out value='${emp.type_contrat}' />" name="type_contrat" class="browser-default custom-select">
                        <option selected>Sélectionnez le type de contrat</option>
                        <option value="CDI">CDI</option>
                        <option value="CDD">CDD</option>
                        <option value="CTT">CTT</option>
                        <option value="CUI">CUI</option>
                    </select>
				</fieldset>
								<fieldset class="form-group">
					<label>Sexe</label> 
				<select value="<c:out value='${emp.sexe}' />" name="sexe" class="browser-default custom-select">
                        <option selected>Sélectionnez le sexe</option>
                        <option value="M">Masculin</option>
                        <option value="F">Féminin</option>
                    </select>
				</fieldset>
						<fieldset class="form-group">
					<label>Poste</label> <input type="text"
						value="<c:out value='${emp.poste}' />" class="form-control"
						name="poste" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${emp.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>TEL</label> <input type="text"
						value="<c:out value='${emp.num_tel}' />" class="form-control"
						name="num_tel" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label>Date Naissance</label> <input type="text"
						value="<c:out value='${emp.date_naissance}' />" class="form-control"
						name="date_naissance" required="required">
				</fieldset>
						<fieldset class="form-group">
					<label >Date Entrée</label> <input type="text"
						value="<c:out value='${emp.date_entree}'  />" class="form-control"
						name="date_entree" required="required">
				</fieldset>
	



		
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
				</form>
			</div>
		</div>
	</div>
</body>
</html>