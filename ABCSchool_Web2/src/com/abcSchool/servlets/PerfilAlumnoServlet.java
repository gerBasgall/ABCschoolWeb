package com.abcSchool.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;
import dto.AlumnoDTO;
import dto.ReservaDTO;

public class PerfilAlumnoServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dniAlumno = request.getParameter("dniAlumno");
			AlumnoDTO alumno=null;
			ArrayList<ReservaDTO> reservas =null;
			try {
				alumno = BusinessDelegate.getInstancia().buscarAlumno(dniAlumno);
			} catch (CommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //REVISAR la llamada al bd
			try {
				reservas = BusinessDelegate.getInstancia().obtenerReservasAlumno(dniAlumno);
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