package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Contrato;
import dominio.Hotel;
import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			Cliente cl1 = new Cliente(null, "Helena", "helena@hotmail.com", "(34) 99145-7898", "111.222.333-4", sdf.parse("24/03/1986"), new BigDecimal("4400.00"));
			Cliente cl2 = new Cliente(null, "Marcos", "marcos@hotmail.com", "(34) 99288-5568", "555.444.666-00", sdf.parse("12/07/1974"), new BigDecimal("3000.00"));
			Cliente cl3 = new Cliente(null, "Rita", "rita@hotmail.com", "(34) 99685-2259", "777.888.999-11", sdf.parse("03/01/1993"), new BigDecimal("1500.00"));

			Hotel h1 = new Hotel(null, "Hotel Tulipas", "Arraial d’ Ajuda", new BigDecimal("150.00"));
			Hotel h2 = new Hotel(null, "Hotel do Porto", "Porto Seguro", new BigDecimal("140.00"));
			Hotel h3 = new Hotel(null, "Hibs Hotel", "Rio de Janeir", new BigDecimal("120.00"));
			
			Passeio ps1 = new Passeio(null, "Recife de Fora", new BigDecimal("120.00"));
			Passeio ps2 = new Passeio(null, "Ilha dos Aquários", new BigDecimal("60.00"));
			Passeio ps3 = new Passeio(null, "Pão de Açúcar", new BigDecimal("45.00"));
			Passeio ps4 = new Passeio(null, "Corcovado", new BigDecimal("60.00"));
			Passeio ps5 = new Passeio(null, "Cidade Histórica", new BigDecimal("10.00"));
			Passeio ps6 = new Passeio(null, "Eco Parque Arraial d' Ajuda", new BigDecimal("100.00"));
			Passeio ps7 = new Passeio(null, "Cristo Redentor", new BigDecimal("60.00"));
			Passeio ps8 = new Passeio(null, "Floresta da Tijuca", new BigDecimal("50.00"));
			
			Pacote p1 = new Pacote(null, "Ferias de julho Arraial d’ ajuda", 6, h1);
			Pacote p2 = new Pacote(null, "Ferias Final de ano Porto Seguro", 12, h2);
			Pacote p3 = new Pacote(null, "Ferias julho Rio de Janeiro", 5, h3);
			Pacote p4 = new Pacote(null, "Férias de Final de ano Rio de Janeiro", 14, h3);
			
			Item i1 = new Item(null, 1, p1,ps1);
			Item i2 = new Item(null, 2, p1,ps6);
			Item i3 = new Item(null, 3, p1,ps2);
			Item i4 = new Item(null, 1, p2,ps5);
			Item i5 = new Item(null, 2, p2,ps1);
			Item i6 = new Item(null, 3, p2,ps2);
			Item i7 = new Item(null, 1, p3,ps3);
			Item i8 = new Item(null, 2, p3,ps7);
			Item i9 = new Item(null, 3, p3,ps4);
			Item i10 = new Item(null, 1, p4,ps3);
			Item i11 = new Item(null, 2, p4,ps8);
			Item i12 = new Item(null, 3, p4,ps4);
			
			/*p1.addItem(i1);
			p1.addItem(i2);
			p1.addItem(i3);
			
			p2.addItem(i4);
			p2.addItem(i5);
			p2.addItem(i6);
			
			p3.addItem(i7);
			p3.addItem(i8);
			p3.addItem(i9);
			
			p4.addItem(i10);
			p4.addItem(i11);
			p4.addItem(i12);*/
			
			Contrato cr1 = new Contrato(null, sdf.parse("10/02/2016"), cl1, p2);
			Contrato cr2 = new Contrato(null, sdf.parse("25/07/2016"), cl1, p3);
			Contrato cr3 = new Contrato(null, sdf.parse("17/02/2016"), cl2, p1);
			Contrato cr4 = new Contrato(null, sdf.parse("21/07/2016"), cl2, p4);
			Contrato cr5 = new Contrato(null, sdf.parse("12/06/2016"), cl3, p1);
			
			/*cl1.addContrato(cr1);
			cl1.addContrato(cr2);
			cl2.addContrato(cr3);
			cl2.addContrato(cr4);
			cl3.addContrato(cr5);
			
			p1.addContrato(cr3);
			p1.addContrato(cr5);
			p2.addContrato(cr1);
			p3.addContrato(cr2);
			p4.addContrato(cr4);*/
			
			//ArtistaServico as = new ArtistaServico();
			//FilmeServico fs = new FilmeServico();
			//ParticipacaoServico ps = new ParticipacaoServico();
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(cl1);
			em.persist(cl2);
			em.persist(cl3);
			
			em.persist(h1);
			em.persist(h2);
			em.persist(h3);
			
			em.persist(ps1);
			em.persist(ps2);
			em.persist(ps3);
			em.persist(ps4);
			em.persist(ps5);
			em.persist(ps6);
			em.persist(ps7);
			em.persist(ps8);
			
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			
			em.persist(i1);
			em.persist(i2);
			em.persist(i3);
			em.persist(i4);
			em.persist(i5);
			em.persist(i6);
			em.persist(i7);
			em.persist(i8);
			em.persist(i9);
			em.persist(i10);
			em.persist(i11);
			em.persist(i12);
			
			em.persist(cr1);
			em.persist(cr2);
			em.persist(cr3);
			em.persist(cr4);
			em.persist(cr5);
			
			em.getTransaction().commit();
			em.close();
			emf.close();
			
			//response.getWriter().append("Preço Total do Pacote" + p1 + "\n");
			//response.getWriter().append(p1.precoTotal() + "\n");
			//response.getWriter().append("\n Preço Total dos Passeios " + p1 + "\n");
			//response.getWriter().append(p1.precoPasseio() + "\n");
			

			response.getWriter().append("Pronto!");
		
		}
		catch (ParseException e){
			response.getWriter().append("Erro ao instanciar data. Instanciação não cria!");
		}
		
	}

}
