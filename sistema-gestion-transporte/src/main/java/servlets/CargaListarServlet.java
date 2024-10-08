package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CargaDao;
import dao.impl.CargaDaoImpl;
import models.Carga;

@WebServlet("/listar-cargas")
public class CargaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CargaDao cargaDao;
       
    public CargaListarServlet() {
        super();
        cargaDao = new CargaDaoImpl(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Carga> cargas = cargaDao.listarCargas();
		
		request.setAttribute("cargas", cargas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cargas-listar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
