package com.abcSchool.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.BusinessDelegate;

/**
 * Servlet implementation class ReservaClase
 */
@WebServlet("/ReservaClase")
public class ReservaClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaClase() {
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
		String idClase=request.getParameter("num");
		//BusinessDelegate.getInstancia().altaReserva(idReserva, descuento, monto, cantAlum, paga, fecha, dniAlumno, clases);
		//BusinessDelegate.getInstancia().generarFactura(idReserva, tipo, remitente, medioPago);
	}

}
