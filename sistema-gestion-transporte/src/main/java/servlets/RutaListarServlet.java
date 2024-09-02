package servlets;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/listar-rutas/*")
public class RutaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RutaDao rutaDao;
       
    public RutaListarServlet() {
        super();
        rutaDao = new RutaDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String pathInfo = request.getPathInfo();
		String provincia = Util.extractDataFromPath(pathInfo, 1);
		
		List<Ruta> rutas = rutaDao.listarRutas(provincia);
		
		request.setAttribute("rutas", rutas);
		request.setAttribute("provincia", provincia);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/rutas-listar.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
