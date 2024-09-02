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

@WebServlet("/registrar-ruta")
public class RutaRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RutaDao rutaDao;
       
    public RutaRegistrarServlet() {
        super();
        rutaDao = new RutaDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/rutas-registrar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ruta ruta = new Ruta();
		ruta.setProvincia(request.getParameter("provincia"));
		ruta.setNombreRuta(request.getParameter("nombre_ruta"));
		ruta.setLatitudOrigen(request.getParameter("latitud_origen"));
		ruta.setLongitudOrigen(request.getParameter("longitud_origen"));
		ruta.setLatidudDestino(request.getParameter("latitud_destino"));
		ruta.setLongitudDestino(request.getParameter("longitud_destino"));

		rutaDao.insertarRuta(ruta);
		
		response.sendRedirect(request.getContextPath() + "/listar-rutas/" + ruta.getProvincia());
	}
}
