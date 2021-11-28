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
	
	.bienvenida, .texto {
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
	<div class="contenedor-image">
		<img class="logo" alt="logo" src="/logo.png">
	</div>
	
	<p class="bienvenida">Bienvenido ${usuario.getNombreUsuario() }</p>
	
	<h3>Detalle del Evento Seleccionado</h3>
	
	<table class="tabla">
		<tr>
			<td>Nombre</td>
			<th>${evento.getNombreEvento() }</th>
		</tr>
		<tr>
			<td>Descripción</td>
			<th>${evento.getDescripcionEvento() }</th>
		</tr>
		<tr>
			<td>Dirección</td>
			<th>${evento.getDireccionEvento() }</th>
		</tr>
		<tr>
			<td>Fecha inicio</td>
			<th><fmt:formatDate pattern="dd-MM-yyyy" value="${evento.getFechaEvento()}" /></th>
		</tr>
		<tr>
			<td>Duración</td>
			<th>${evento.getDuracionEvento() }</th>
		</tr>
		<tr>
			<td>Aforo máximo</td>
			<th>${evento.getAforoMaximo() }</th>
		</tr>
		<tr>
			<td>Asistencia mínima</td>
			<th>${evento.getMinimoAsistencia() }</th>
		</tr>
		<tr>
			<td>Precio unitario</td>
			<th><fmt:formatNumber type="number" maxFractionDigits="2" value="${evento.getPrecio() }" /></th>
		</tr>
	</table>
	
	<div class="texto">Quedan ${evento.getPlazasDisponibles() } entradas</div>
	
	<div>
		<img alt="${evento.getNombreEvento() }" src="/evento.jpeg">
	</div>
	
	<form action="reservar/${evento.getIdEvento() }" method="post" class="texto">
		<p>
			<p>Cantidad</p>
			<input type="number" max="10" min="1" name="cantidad">
		</p>
		<p><input type="submit" value="Reservar" id="boton"></p>
	</form>		
	
	<p class="texto">Puedes volver al listado de eventos activos <a href="/clientes/activos">aquí.</a></p>
	
</body>
</html>