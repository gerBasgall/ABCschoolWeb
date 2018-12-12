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
import dto.ReservaDTO;

/**
 * Servlet implementation class ObtenerReservasServlet
 */
@WebServlet("/ObtenerReservas")
public class ObtenerReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerReservasServlet() {
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
		System.out.println("obteniendo las reservas del alumno");
		String dni = request.getParameter("dni");		
		ArrayList<ReservaDTO> reservas= new ArrayList<ReservaDTO>();
		try {
			reservas = BusinessDelegate.getInstancia().obtenerReservasAlumno(dni);
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("reservas", reservas);
		RequestDispatcher rd = request.getRequestDispatcher("CancelarReservaServlet.jsp");
		rd.forward(request, response);
	}

}
