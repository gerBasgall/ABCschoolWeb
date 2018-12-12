<%@page import="delegates.BusinessDelegate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.List"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="dto.ReservaDTO"%>
<%@ page import ="dto.ClaseDTO"%>
<%@ page import ="dto.ProfesorDTO"%>
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
    
 <% HttpSession context = request.getSession();
	String usuario = (String)context.getAttribute("usuario");
 
 	ArrayList<ReservaDTO> reservas = BusinessDelegate.getInstancia().obtenerReservasAlumno(usuario);
    ArrayList<ClaseDTO> c2 = new  ArrayList<ClaseDTO>();
	for(ReservaDTO r : reservas){
		ArrayList<ClaseDTO> clases = BusinessDelegate.getInstancia().obtenerClasesReserva(r.getIdReserva());
		for(ClaseDTO c : clases){
			r.addClase(c);
			c2.add(c);
		//	ProfesorDTO profesor = BusinessDelegate.getInstancia().buscarProfesor(c.getProfesor());
			//c.setProfesor(profesor.getNombre());
		}
	}%>
<%-- <%ArrayList<ReservaDTO> list = new ArrayList<ReservaDTO>();%>
<%list = (ArrayList<ReservaDTO>) request.getAttribute("PerfilAlumnoServlet");%> --%>
<%-- <%ArrayList<ClaseDTO> clases = new ArrayList();
    		  for(ReservaDTO r : list){
    			  for(ClaseDTO c : r.getClases()){
    				  clases.add(c);
    			  }
    		  }
    		  %>--%>
    		  
    		  
<h1 style="vertical-align: inherit; background-color: white; width: 360px; height: 46px; color: #ff6600;">Mis proximas clases:</h1>
 
 <table align="center" width="100%">
      <tbody>
        <tr>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Materia</span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #996633;"><span style="color: #ff6600;">Profesor DNI</span></span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Día<br>
              </span></b></th>
        </tr>
        <% for(ClaseDTO c : c2) { %>
        <tr>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;"><%out.println(c.getMateria());%></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #996633;"><span style="color: #ff6600;"><%out.println(c.getProfesor());%></span></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;"><%out.println(c.getFecha());%><br>
              </span></b></th>
          
        </tr>
    <% } %>
      </tbody>
        
    </table>

  </body>
  
  </html>