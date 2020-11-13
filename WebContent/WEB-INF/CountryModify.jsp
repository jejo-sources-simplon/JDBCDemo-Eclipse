<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Pays</title>
		<link rel="stylesheet" type="text/css" href="styles.css">		
	</head>
	
	<body>
		<h1>Modifier un pays de la liste des pays</h1>
		
		<form action='helloworld' method='post'>
			<label class='label2' for='nomPays'>Nom à modifier :</label>
			<input name='nomPays' id='nomPays' type='text' autofocus/>
			<br />
			<label for='nouvNomPays'>Nouveau nom :</label>
			<input name='nouvNomPays' id='nouvNomPays' type='text' />	
			<br /><br />
			<input type='submit' name='btn21' value='Modifier' />			
			<input type='submit' name='btn22' value='Menu' />	
		</form>
		
		<ul>
			<c:forEach var="pays" items="${listePays}">
				<li><c:out value="${pays.nom}"/></li>
			</c:forEach>
		</ul>
	
	</body>
	
</html>