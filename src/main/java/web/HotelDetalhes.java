package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Hotel;
import servico.HotelServico;

@WebServlet("/hotel/detalhes")
public class HotelDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/hotel/detalhes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HotelServico h = new HotelServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Hotel hotel = h.buscar(cod);
		request.setAttribute("item", hotel);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
