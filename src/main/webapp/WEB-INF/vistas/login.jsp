<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 2 - DAWES</title>
<style type="text/css">
	body {
		font-family: "sans-serif";
	}
	
	#boton {
		border-radius: 5px;
		border: 2px solid #00ACFF 
	}
</style>
</head>
<body>
<!-- En esta vista se muestran el formulario para hacer login -->
	<form action="login" method="post">
		<p>
			<p>Email</p>
			<input type="email" name="emailUsuario" >
		</p>
		<p>
			<p>Contraseña</p>
			<input type="password" name="passwordUsuario" >
		</p>
		<p><input type="submit" value="Enviar" id="boton"></p>
	</form>		
</body>
</html>