package servico;

import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Cliente;

public class ClienteServico {
	
private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	
	public void inserirAtualizar(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscarCpfExato(x.getCpf());
			if (aux != null){
				throw new ServicoException("CPF j� existente!", 1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro" + e.getMessage());
		}
	}
	
	public void excluir(Cliente x){
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro" + e.getMessage());
		}
	}
	
	public Cliente buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public List<Cliente> buscarTodosOrdenadosPorNome(){
		return dao.buscarTodosOrdenadosPorNome();
	}

	
	
}
