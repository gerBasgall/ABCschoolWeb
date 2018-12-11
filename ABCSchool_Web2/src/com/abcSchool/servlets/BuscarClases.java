package com.abcSchool.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

/**
 * Servlet implementation class BuscarClases
 */
@WebServlet("/BuscarClases")
public class BuscarClases extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClases() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String materia = request.getParameter("materia");
		String profesor = request.getParameter("profesor");
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		
		BusinessDelegate.getInstancia().buscarMateria(materia);
		//faltan metodos de filtrado + devolver las clases
	}

}
