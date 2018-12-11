package com.abcSchool.servlets;

import java.io.IOException;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;
import dto.ProfesorDTO;

/**
 * Servlet implementation class ProfesorServlet
 */
@WebServlet(name = "Profesor", urlPatterns = { "/Profesor" })
public class ProfesorServlet extends HttpServlet
{

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dniProfesor = request.getParameter("dniProfesor");
			ProfesorDTO profesor = null;
			try {
				profesor = BusinessDelegate.getInstancia().buscarProfesor(dniProfesor);
			} catch (CommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //REVISAR la llamada al bd
			request.setAttribute("profesor",profesor);
			String jsp="/Profesor.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
	        rd.forward(request, response);
		}
}
