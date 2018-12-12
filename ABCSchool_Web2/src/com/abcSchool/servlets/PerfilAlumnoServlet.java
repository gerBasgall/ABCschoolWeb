package com.abcSchool.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delegates.BusinessDelegate;
import dto.AlumnoDTO;
import dto.ClaseDTO;
import dto.ReservaDTO;

@WebServlet("/PerfilAlumno")
public class PerfilAlumnoServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("entre al perfilAlumno");
			HttpSession context = request.getSession();
			String usuario = (String)context.getAttribute("usuario");
			request.setAttribute("usuario",usuario);
			System.out.println("PerfilAlumnoServlet  " + usuario);
			//String dniAlumno = request.getParameter("dniAlumno");
			AlumnoDTO alumno=null;
			ArrayList<ReservaDTO> reservas =null;
			try {
				alumno = BusinessDelegate.getInstancia().buscarAlumno(usuario);
				System.out.println("PerfilAlumnoServlet  " + alumno.getContra());
			} catch (CommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //REVISAR la llamada al bd
			try {
				reservas = BusinessDelegate.getInstancia().obtenerReservasAlumno(usuario);
				for(ReservaDTO r : reservas){
					ArrayList<ClaseDTO> clases = BusinessDelegate.getInstancia().obtenerClasesReserva(r.getIdReserva());
					for(ClaseDTO c : clases){
						r.addClase(c);
					}
				}
			} catch (CommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("alumno",alumno);
			request.setAttribute("reservas",reservas);
			String jsp="/PerfilAlumno.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
	        rd.forward(request, response);
		}
}