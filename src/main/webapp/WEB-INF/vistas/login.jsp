<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 2 - DAWES</title>
</head>
<body>
	<form action="/login" method="post">
		<p>Usuario<input type="text" name="usuario" ></p>
		<p>Contraseña<input type="text" name="password" ></p>
		<p><input type="submit" value="Enviar"></p>
	</form>		
</body>
</html>