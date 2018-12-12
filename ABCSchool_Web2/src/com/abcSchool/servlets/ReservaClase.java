package com.abcSchool.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.CommunicationException;
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
		ArrayList<String> res = new ArrayList<String>();
		res.add(idClase);
		try {
			BusinessDelegate.getInstancia().altaReserva(-1, 0f, 400f, 1, false, Calendar.getInstance().getTime(), "1", res);
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BusinessDelegate.getInstancia().generarFactura(idReserva, tipo, remitente, medioPago);
	}

}
