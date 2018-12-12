<%@page import="delegates.BusinessDelegate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="dto.ClaseDTO"%>

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
		<form action="ClasesDisponibles" name="formulario" method="post">
			<tr>
				<td>Materia:</td>
				<td><select style="width: 145px;" id="log" name="materia"
					required>
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
				<td><select style="width: 145px;" id="log" name="profesor"
					required>
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
				<td></td>
				<td><input type="submit" value="Buscar"></td>
			</tr>
		</form>
	</table>
	<br>

  

<% ArrayList<ClaseDTO> list = BusinessDelegate.getInstancia().verClasesDisponibles();
//ArrayList<ClaseDTO> list = (ArrayList<ClaseDTO>) request.getAttribute("ClasesDisponibles");

// print the information about every category of the list
/*for(String category : list) {
    out.println(category.getId());
    out.println(category.getName());
    out.println(category.getMainCategoryId());
}*/
%>

	<table align="center" width="100%">
		<form action="ReservaClase" name="formulario" method="post">
			<tbody>
				<tr>
					<th 
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 31%; height: 46px;"><b><span
							style="color: #ff6600;">Materia</span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 31%; height: 46px;"><b><span
							style="color: #996633;"><span style="color: #ff6600;" >Profesor DNI</span></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940); width: 31%; height: 46px;"><b><span
							style="color: #ff6600;">Dia<br>
						</span></b></th>
				</tr>
				<%
					for (ClaseDTO c : list) {
				%>
				<tr>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);"><b><span
							style="color: #ff6600;"><%out.println(c.getMateria());%></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);" ><b><span
							style="color: #996633;"><span style="color: #ff6600;" class="popup" onclick="myFunction()"><%out.println(c.getProfesor());%><span class="popuptext" id="myPopup">&#11088; &#11088; &#11088;</span></span></span></b></th>
					<th
						style="vertical-align: inherit; background: linear-gradient(#FFDA63, #FFB940);"><b><span
							style="color: #ff6600;"><%out.println(c.getFecha());%><br>
						</span></b></th>

					<th style="vertical-align: inherit;"><b><span
							style="color: #ff6600;"><button type="submit" name=num value=<%out.println(c.getIdClase());%>">Agregar
									a reserva</button> <br> </span></b></th>

				</tr>
				<%
					}
				%>
			</tbody>
			</form>
	</table>
	</table>
	<button>Reservar</button>

<style>
/* Popup container - can be anything you want */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* The actual popup */
.popup .popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
  from {opacity: 0;} 
  to {opacity: 1;}
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity:1 ;}
}
</style>

<script>
// When the user clicks on div, open the popup
function myFunction() {
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}
</script>

</body>
</html>