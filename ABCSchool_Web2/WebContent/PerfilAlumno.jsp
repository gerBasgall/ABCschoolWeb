<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.List"%>
<%@ page import ="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- utf-8 para idioma español-->
    <meta charset="utf-8">
    <!-- viewport = todo lo que vez por pantalla; width= ancho de la pantalla; user-scalable si se puede hacer zoom o no-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale-1, minimun-scale=1">
    <title>ABC school</title>
    <!-- enlazo css con el doc html-->
    <link rel="stylesheet" href="css/Alumno/main.css">
  </head>
  <body>
   <header>
      <input type="checkbox" id="btn-menu">
      <label for="btn-menu"><img src="img/cloud-with-three-menu-dots_icon-icons.com_56533.png"></label>
      <nav class="menu">
        <ul>
          <li><a href="PerfilAlumno.jsp">Mis reservas</a></li>
          <li><a href="ReservaTuClase.jsp">Reserva tu clase</a></li>
		  <li><a href="CancelarClase.jsp">Cancela una clase</a></li>
          <li><a href="">Mi perfil</a></li>
          <ul class="end">
            <li><a href="Inicio.jsp">
              <span>Cerrar sesion</span>
              </a>
            </li>
          </ul>
          
        </ul>
      </nav>
    </header>


<h1 style="vertical-align: inherit; background-color: white; width: 360px; height: 46px; color: #ff6600;">Mis proximas clases:</h1>
 
 <table align="center" width="100%">
      <tbody>
        <tr>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Materia</span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #996633;"><span style="color: #ff6600;">Profesor</span></span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Día<br>
              </span></b></th>
        </tr>
        <% for(int i=0; i<5; i++) { %>
        <tr>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;"><%= i  %></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #996633;"><span style="color: #ff6600;">matematica</span></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;">matematica<br>
              </span></b></th>
          
        </tr>
    <% } %>
      </tbody>
        
    </table>
 
  </body>
  
  </html>