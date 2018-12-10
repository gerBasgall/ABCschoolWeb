package com.abcSchool.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.CommunicationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

/**
 * Servlet implementation class AltaAlumnoServlet
 */
@WebServlet("/AltaAlumno")
public class AltaAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAlumnoServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ON alta alumno");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String domicilio = request.getParameter("domicilio");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		String fechaNac = request.getParameter("fechaNac");
		String pass = request.getParameter("pass");
		//String passConf = request.getParameter("passConf");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try
		{
			date = format.parse (fechaNac);
		}
		catch (ParseException e1)
		{
			e1.printStackTrace();
		}
		if (date != null)
		{
			try
			{
				BusinessDelegate.getInstancia().altaAlumno(dni, nombre, mail, telefono, domicilio, date, pass);
			}
			catch (CommunicationException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
