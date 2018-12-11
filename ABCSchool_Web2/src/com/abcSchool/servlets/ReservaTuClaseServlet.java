package com.abcSchool.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.naming.CommunicationException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;
import dto.MateriaDTO;
import dto.ProfesorDTO;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(name = "ReservaTuClase", urlPatterns = { "/ReservaTuClase" })
@WebServlet("/Login")
public class ReservaTuClaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaTuClaseServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("trying to do something");
		String materia = request.getParameter("myInputMateria");
		String prof = request.getParameter("myInputProfesor");
		MateriaDTO m= null;
		ProfesorDTO p=null;
		try {
			 m=BusinessDelegate.getInstancia().buscarMateria(materia);
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		p=BusinessDelegate.getInstancia().buscarProfesor(prof);
		
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletContext context = getServletContext();
		String usuario = (String)context.getAttribute("usuario");
	if (p!=null && m!=null) {
		BusinessDelegate.getInstancia().altaReserva(-1, 0, 400, 1, 0, Calendar.getInstance().getTime(),usuario , clases);
	}
	}

}
