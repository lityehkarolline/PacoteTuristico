package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;
import servico.ClienteServico;
import servico.ContratoServico;
import servico.HotelServico;
import servico.ItemServico;
import servico.PacoteServico;
import servico.PasseioServico;
import servico.ServicoException;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.parse("01/01/2000");
		
		ClienteServico cls = new ClienteServico();
		HotelServico hs = new HotelServico();
		PasseioServico pss = new PasseioServico();
		PacoteServico ps = new PacoteServico();
		ItemServico is = new ItemServico();
		ContratoServico crs = new ContratoServico();
		
		// Tentando inserir um Cliente com CPF repetido:
		/*Cliente cl3 = new Cliente(null, "Mario", "mario@hotmail.com", "(34) 99685-2000", "777.888.999-11", sdf.parse("03/01/1998"), new BigDecimal("1700.00"));
				try {
					cls.inserir(cl3);
					response.getWriter().append("Mario inserido!\n");
				}
				catch (ServicoException e) {
						response.getWriter().append(e.getMessage()+"\n");
					}*/
		
		
		// Tentando atualizar um Cliente (1) "Apenas a renda":
		/*Cliente cl1 = cls.buscar(1);
			try {
				cl1.setRendaMensal(cl1.getRendaMensal().add(new BigDecimal("1.00")));
				cls.atualizar(cl1);
				response.getWriter().append("Cliente atualizado!\n");
			}
			catch (ServicoException e) {
					response.getWriter().append(e.getMessage()+"\n");
			}*/
		
		// Tentando atualizar um artista (2) "Com nome repetido":
		/*Cliente cl1 = cls.buscar(1);
					try {
						cl1.setNome("Rita");
						cls.atualizar(cl1);
						response.getWriter().append("Cliente atualizado!\n");
					}
					catch (ServicoException e) {
						response.getWriter().append(e.getMessage()+"\n");
					}*/
		
		
		// Realizando a consulta nos Hoteis:
		/*List<Hotel> lista = hs.buscarPorNomeDiaria("s", new BigDecimal("100.00"),  new BigDecimal("130.00"));
					for (Hotel x : lista) {
						response.getWriter().append(x + "\n");
					}*/
		
		
		/*// Tentando inserir uma participacao repetida:
		
				Pacote p4 = ps.buscar(2);
				Passeio ps3 = pss.buscar(1);
		 		
				Item i = new Item(null, 1, p4, ps3);
				try {
					is.inserir(i);
					response.getWriter().append("Participacao inserida!\n");
					}
				catch (ServicoException e) {
						response.getWriter().append(e.getMessage());
				}
				
		//Item i1 = new Item(null, 1, p1,ps1);*/
		
	}
	catch (ParseException e) {
			response.getWriter().append("Data inválida!");
	}
}
}	
