package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Hotel;
import servico.HotelServico;

@WebServlet("/hotel/resultado")
public class HotelResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/hotel/resultadoBusca.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HotelServico h = new HotelServico();
		String nome = request.getParameter("nome");
		BigDecimal diariaMin = new BigDecimal(request.getParameter("diariaMin"));
		BigDecimal diariaMax = new BigDecimal(request.getParameter("diariaMax"));			
		List<Hotel> itens = h.buscarPorNomeDiaria(nome, diariaMin, diariaMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
		
	}
}
