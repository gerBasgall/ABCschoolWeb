package com.abcSchool.servlets;

import java.io.IOException;

import javax.naming.CommunicationException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(name = "Login", urlPatterns = { "/Login" })
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("trying to login");
		String usr = request.getParameter("usr");
		String clave = request.getParameter("clave");
		String rol = request.getParameter("rol");
		int codigo = -1;
		if(rol.equals("alum"))
		{
			codigo = 1;
		}
		else if(rol.equals("prof"))
		{
			codigo = 2;
		}
		else if(rol.equals("admin"))
		{
			codigo = 3;
		}
		try
		{
			System.out.println(codigo);
			boolean loggedIn = BusinessDelegate.getInstancia().loginCliente(usr, clave, codigo);
			if (loggedIn)
			{
				ServletContext context = getServletContext();
				context.setAttribute("usuario", usr);
				if (codigo == 1)
				{
					System.out.println("alumno logged in");
					response.sendRedirect("Alumno.jsp");
				}
				else if (codigo == 2)
				{
					System.out.println("profesor logged in");
					response.sendRedirect("Profesor.jsp");
				}
			/*	else if (codigo == 3)
				{
					RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");  
					//servlet2 is the url-pattern of the second servlet  
					  
					rd.forward(request, response);
				}*/		
			}
			else
			{
				System.out.println(">:C");
			}
		}
		catch (CommunicationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
