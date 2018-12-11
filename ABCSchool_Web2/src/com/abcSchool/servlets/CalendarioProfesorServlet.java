package com.abcSchool.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delegates.BusinessDelegate;
import dto.MateriaDTO;
import dto.ProfesorDTO;

/**
 * Servlet implementation class CalendarioProfesorServlet
 */
@WebServlet(name = "CalendarioProfesor", urlPatterns = { "/CalendarioProfesor" })
public class CalendarioProfesorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarioProfesorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession context = request.getSession();
		String usuario = (String)context.getAttribute("usuario");
		System.out.println(usuario);
		request.setAttribute("usuario",usuario);
		Integer profesorId = 1;
		/*try
		{
			profesorId = BusinessDelegate.getInstancia().buscarProfesor(usuario).getIdUsuario();
		} catch (CommunicationException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		List<MateriaDTO> materias = new ArrayList <MateriaDTO>();
		try {
			materias = BusinessDelegate.getInstancia().obtenerMateriasProfesor(1);
		}
		catch (NumberFormatException | CommunicationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("materias", materias);
		RequestDispatcher dispatch = request.getRequestDispatcher("CalendarioProfesor.jsp");
        dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
