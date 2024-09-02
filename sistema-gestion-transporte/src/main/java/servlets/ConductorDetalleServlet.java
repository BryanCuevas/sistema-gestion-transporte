package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ConductorDao;
import dao.RutaDao;
import dao.impl.ConductorDaoImpl;
import dao.impl.RutaDaoImpl;
import models.Conductor;
import utils.Util;

@WebServlet("/buscar-conductor/*")
public class ConductorDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConductorDao conductorDao;
	private RutaDao rutaDao;
       
    public ConductorDetalleServlet() {
        super();
        conductorDao = new ConductorDaoImpl();
        rutaDao = new RutaDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = Util.extractDataFromPath(pathInfo, 1);
		
		Conductor conductor = conductorDao.obtenerConductor(Integer.parseInt(id));
		request.setAttribute("conductor", conductor);
		
		String nombreRuta = rutaDao.obtenerRuta(conductor.getIdRuta()).getNombreRuta();
		request.setAttribute("nombreRuta", nombreRuta);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/conductores-detalle.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
