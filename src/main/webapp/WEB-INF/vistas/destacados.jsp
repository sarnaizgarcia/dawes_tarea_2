<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 2 - DAWES</title>
<style type="text/css">
	body {
		font-family: "sans-serif";
	}
	
	h1, h3 {
		color: #8127B0;
		margin: 15px;	
	}
	
	.bienvenida {
		margin: 15px;
	}
	.logo {
		width: 50px;
	}
	
	.contenedor-image {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 80px;
		height: 80px;
		border: solid black 1px;
		border-radius: 50%;
		margin: 15px;
		
	}
	
	.eventos {
		border: solid #00ACFF;
		width: 218px;
		text-align: center;
		margin: 15px;
		height: 30px;
	}
	
	.contenedor {
		  display: grid;
		  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
		  grid-template-rows: 1fr 1fr;
		  gap: 6px 6px;
		  grid-auto-flow: row;
		  grid-template-areas:
		    "destacado tipo reservas resgistro salir"
		    "activos tipo reservas resgistro salir";
		margin: 15px;
		width: 60%;
	}

	.tipo { 
		grid-area: tipo;
		border: solid #00ACFF;
		text-align: center;
	}
	
	.reservas { 
		grid-area: reservas;
		border: solid #00ACFF;
		text-align: center;
	}
	
	.destacado { 
		grid-area: destacado;
		border: solid #00ACFF;
		text-align: center;
	}
	
	.activos { 
		grid-area: activos;
		border: solid #00ACFF;
		text-align: center;
	}
	
	.resgistro { 
		grid-area: resgistro;
		border: solid #00ACFF;
		text-align: center;
	}
	
	.salir { 
		grid-area: salir;
		border: solid #00ACFF;
		text-align: center;
	}
	
	table, td, th {
	  	border: 2px solid #00ACFF;
	  	margin: 15px;
	}
</style>

</head>
<body>

	<h1 class="titulo">Eventos Destacados</h1>

	<div class="contenedor-image">
		<img class="logo" alt="logo" src="/logo.png">
	</div>
	
	<div class="contenedor">
		<div class="menu-item destacado">Destacados</div>
		<div class="menu-item activos"><a href="activos">Activos</a></div>
		<div class="menu-item tipo">Tipo de evento</div>
		<div class="menu-item reservas">Mis reservas</div>
		<div class="menu-item resgistro">Registro</div>
		<div class="menu-item salir"><a href="cerrarSesion">Salir</a></div>
	</div>			
	
	<p class="bienvenida">Bienvenido ${usuario.getNombreUsuario() }</p>
			
	<h3>Listado de eventos destacados</h3>
	
	<table class="tabla">
		<tr>
			<th>Nombre</th>
			<th>Aforo</th>
			<th>Fecha incio</th>
			<th>Opciones</th>
		</tr>
		<c:forEach var="ele" items="${eventos }">
			<c:if test="${ele.isDestacadoEvento().equals('Sí') }">
				<tr>
					<td>${ele.nombreEvento}</td>
					<td>${ele.aforoMaximo}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${ele.fechaEvento}" /></td>
					<td><a href="detalle/${ele.getIdEvento() }">Detalle</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>