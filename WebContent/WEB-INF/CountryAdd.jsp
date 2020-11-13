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
		<h1>Ajouter un pays à la liste des pays</h1>
		
		<form action='helloworld' method='post'>
			<label for='nomPays'>Nom :</label>
			<input name='nomPays' id='nomPays' type='text' autofocus/>
			<br /><br />
			<input type='submit' name='btn11' value='Ajouter' />			
			<input type='submit' name='btn12' value='Menu' />	
		</form>
		
		<ul>
			<c:forEach var="pays" items="${listePays}">
				<li><c:out value="${pays.nom}"/></li>
			</c:forEach>
		</ul>
	
	</body>
	
</html>