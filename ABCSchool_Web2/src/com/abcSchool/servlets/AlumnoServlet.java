package com.abcSchool.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Alumno", urlPatterns = {"/Alumno" })
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnoServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("Alumno.jsp");
		HttpSession session = request.getSession();
		Boolean loggedIn = (Boolean) session.getAttribute("isLoggedIn");
		if (loggedIn != null && loggedIn)
		{
			Integer codigo = (Integer)session.getAttribute("codigo");
			
				if (codigo == 1)
				{
					System.out.println("alumno alumno logged in");
					
				}
				else
				{
					System.out.println("you're not supposed to be here.");
					RequestDispatcher dispatch = request.getRequestDispatcher("Inicio.jsp");
			        dispatch.forward(request, response);
				}	
		}
		else
		{
			System.out.println("noone was logged in. Asking for log in");
			RequestDispatcher dispatch = request.getRequestDispatcher("Login.jsp");
	        dispatch.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
