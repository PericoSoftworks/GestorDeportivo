<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="cabecera.jsp"></jsp:include>
		<h1>ABRIR / CERRAR PARTIDOS</h1>
		
		<form>
			<table>
				<tr>
					<th>ID</th>
					<th>Jornada</th>
					<th>L</th>
					<th>V</th>
					<th>ESTADO</th>
					<th>VER</th>
				</tr>
				
				<c:forEach var="partido" items="${partidos}">
					<tr>
						<td>${partido.id}</td>
						<td>${partido.jornada}</td>
						<td>${partido.local.nombre}</td>
						<td>${partido.visitante.nombre}</td>
						<td>${partido.estado}</td>
						
						<td><a href="./fichapartido/${partido.id}">Ver</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
	</body>
</html>