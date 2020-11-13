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
		<h1>Menu - Gérer une liste de pays</h1>
		
		<form action='helloworld' method='post'>
			<input type='submit' name='btn1' value='Ajouter' />		
			<input type='submit' name='btn2' value='Modifier' />			
			<input type='submit' name='btn3' value='Supprimer' />					
		</form>
		
		<p>Liste des pays :</p>
		<ul>
			<c:forEach var="pays" items="${listePays}">
				<li><c:out value="${pays.nom}"/></li>
			</c:forEach>
		</ul>
	
	</body>
	
</html>