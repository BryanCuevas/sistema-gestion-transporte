package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ConductorDao;
import dao.impl.ConductorDaoImpl;
import models.Conductor;

@WebServlet("/listar-conductores")
public class ConductorListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConductorDao conductorDao;
       
    public ConductorListarServlet() {
        super();
        conductorDao = new ConductorDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Conductor> conductores = conductorDao.listarConductores();
		
		request.setAttribute("conductores", conductores);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/conductores-listar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
