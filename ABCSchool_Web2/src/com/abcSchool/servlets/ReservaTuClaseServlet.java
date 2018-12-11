package com.abcSchool.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;
import dto.ClaseDTO;
import dto.MateriaDTO;
import dto.ProfesorDTO;
/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(name = "/ReservaTuClase", urlPatterns = { "/ReservaTuClase.jsp" })
@WebServlet("/ReservaTuClase")
public class ReservaTuClaseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaTuClaseServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("uwu");
		ArrayList<MateriaDTO> materias = new ArrayList<MateriaDTO>();
		//materias = BusinessDelegate.getInstancia().obtenerMaterias();
		MateriaDTO m= new MateriaDTO("Lengua",1);
		MateriaDTO m2= new MateriaDTO("Matematica",2);
		MateriaDTO m3= new MateriaDTO("Fisica",3);
		MateriaDTO m4= new MateriaDTO("Programacion",4);
		MateriaDTO m5= new MateriaDTO("Latin",5);
		materias.add(m);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		materias.add(m5);
		request.setAttribute("materias", materias);
		System.out.println(request.getAttribute("materias"));
		RequestDispatcher dispatch = request.getRequestDispatcher("ReservaTuClase.jsp");
        dispatch.forward(request, response);
		//doPost(request, response);
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
		try {
			ArrayList<ClaseDTO>c =new ArrayList<ClaseDTO>();
			//c.add(c);
			BusinessDelegate.getInstancia().altaReserva(-1, 0f, 400f, 1, false, Calendar.getInstance().getTime(),usuario , null /*clases*/);
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
