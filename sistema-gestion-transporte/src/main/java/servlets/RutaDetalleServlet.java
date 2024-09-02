package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RutaDao;
import dao.impl.RutaDaoImpl;
import models.Ruta;
import utils.Util;

@WebServlet("/buscar-ruta/*")
public class RutaDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RutaDao rutaDao;

    public RutaDetalleServlet() {
        super();
        rutaDao = new RutaDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = Util.extractDataFromPath(pathInfo, 1);
		
		Ruta ruta = rutaDao.obtenerRuta(Integer.parseInt(id));
		request.setAttribute("ruta", ruta);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/rutas-detalle.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
