package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CargaDao;
import dao.impl.CargaDaoImpl;
import models.Carga;
import utils.Util;

@WebServlet("/buscar-carga/*")
public class CargaDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CargaDao cargaDao;
       
    public CargaDetalleServlet() {
        super();
        cargaDao = new CargaDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = Util.extractDataFromPath(pathInfo, 1);
		
		Carga carga = cargaDao.obtenerCarga(Integer.parseInt(id));
		request.setAttribute("carga", carga);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cargas-detalle.jsp");
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
