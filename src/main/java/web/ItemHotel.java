package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Hotel;
import servico.HotelServico;

@WebServlet("/item/hotel")
public class ItemHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/item/listarHotel.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HotelServico h = new HotelServico();
		List<Hotel> itens = h.buscarTodos();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
		
	}
}
