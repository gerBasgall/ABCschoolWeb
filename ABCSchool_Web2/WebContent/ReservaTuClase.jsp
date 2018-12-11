<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale-1, minimun-scale=1">
<title>ABC school</title>
<meta charset="utf-8" />
<!-- enlazo css con el doc html-->
<link rel="stylesheet" href="css/Alumno/ReservarClase.css"
	type="text/css" />
</head>
<body>

	<header>
		<input type="checkbox" id="btn-menu"> <label for="btn-menu"><img
			src="images/cloud-with-three-menu-dots_icon-icons.com_56533.png"></label>
		<nav class="menu">
			<ul>
				<li><a href="PerfilAlumno.jsp">Mis clases</a></li>
				<li><a href="ReservaTuClase.jsp">Reserva tu clase</a></li>
				<li><a href="CancelarClase.jsp">Cancela una clase</a></li>
				<li><a href="">Mi perfil</a></li>
				<ul class="end">
					<li><a href="Inicio.jsp"> <span>Cerrar sesion</span>
					</a></li>
				</ul>
			</ul>
		</nav>
	</header>

	<h1 style="color: #ff6600;">Filtrar por:</h1>
	<table
		style="background: linear-gradient(#FFDA63, #FFB940); width: 220px; height: 60px;">
		<form action="BuscarClases" name="formulario" method="post">
		<tr>
			<td>Materia:</td>
			<td><select style="width: 145px;" id="log" name="materia" required>
					<option value="selec">-seleccion-</option>
					<option value="lengua">Lengua</option>
					<option value="matematicas">Matematicas</option>
					<option value="historia">Historia</option>
					<option value="civica">Civica</option>
					<option value="ingles">Ingles</option>
					<option value="frances">Frances</option>
					<option value="chino">Chino</option>
			</select></td>
		</tr>
		<tr>
			<td>Profesor:</td>
			<td><select style="width: 145px;" id="log" name="profesor" required>
					<option value="selec">-seleccion-</option>
					<option value="marco">Marco</option>
					<option value="facundo">Facundo</option>
					<option value="agustina">Agustina</option>
					<option value="florencia">Florencia</option>
					<option value="german">German</option>
					<option value="julian">Julian</option>
			</select></td>
		</tr>
		<td>Fecha:</td>
		<td><input type="date" name="fecha"></td>
		<tr>
			<td>Horarios:</td>
			<td><input type="time" name="hora"></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="Buscar"></td>
		</tr>
		</form>
	</table>
<br>

	<table>
		<form action="" name="formulario" method="post">
			<tbody>
				<tr>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 200px; height: 46px;"><b><span
							style="color: #ff6600;">Materia</span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 200px; height: 46px;"><b><span
							style="color: #996633;"><span style="color: #ff6600;">Profesor</span></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 200px; height: 46px;"><b><span
							style="color: #ff6600;">Día<br>
						</span></b></th>
				</tr>
				<% for(int i=0; i<5; i++) { %>
				<tr>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);"><b><span
							style="color: #ff6600;"><%= i  %></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);"><b><span
							style="color: #996633;"><span style="color: #ff6600;">matematica</span></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);"><b><span
							style="color: #ff6600;">matematica<br>
						</span></b></th>

					<th style="vertical-align: inherit; background-color: white;"><b><span
							style="color: #ff6600;"><button
									href="ReservaClase?num=<%= "aca va id clase" %>">Agregar
									a reserva</button>
								<br> </span></b></th>

				</tr>
				<% } %>
			</tbody>
	</table>
	</table>
	<button>Reservar</button>



</body>
</html>