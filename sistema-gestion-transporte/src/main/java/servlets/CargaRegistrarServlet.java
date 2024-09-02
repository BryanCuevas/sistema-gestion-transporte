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

@WebServlet("/registrar-carga")
public class CargaRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CargaDao cargaDao;
       
    public CargaRegistrarServlet() {
        super();
        cargaDao = new CargaDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cargas-registrar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carga carga = new Carga();
		carga.setTipoCarga(request.getParameter("tipo_carga"));
		carga.setDescripcion(request.getParameter("descripcion"));
		carga.setPeso(Integer.parseInt(request.getParameter("peso")));
		
		cargaDao.insertarCarga(carga);
		
		response.sendRedirect(request.getContextPath() + "/listar-cargas");
	}

}
