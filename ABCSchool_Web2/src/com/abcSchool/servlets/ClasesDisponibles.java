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

import delegates.BusinessDelegate;
import dto.ClaseDTO;
import excepciones.ComunicacionException;

/**
 * Servlet implementation class ClasesDisponibles
 */
@WebServlet("/ClasesDisponibles")
public class ClasesDisponibles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ClaseDTO> clases = new ArrayList<ClaseDTO>();
			try {
				clases = BusinessDelegate.getInstancia().verClasesDisponibles();
			} catch (CommunicationException e) {
				e.printStackTrace();
			}
			request.setAttribute("clases", clases);
			String jsp = "/WEB-INF/ReservaClase.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
			
			
		
		
	}
}
