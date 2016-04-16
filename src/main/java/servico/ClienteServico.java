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
	
	public void inserir(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscarCpfExato(x.getCpf());
			if (aux != null){
				throw new ServicoException("CPF já existente!", 1);
			}
			/*
			Cliente c = dao.buscarNomeExato(x.getNome());
			if (c != null){
				throw new ServicoException("Já existe um cliente com esse nome!", 1);
			}*/
			
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
	
	public void atualizar(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscarCpfExatoDiferente(x.getCodCliente(),x.getCpf());
			if (aux != null){
				throw new ServicoException("CPF já existente!", 1);
			}
			/*
			Cliente c = dao.buscarNomeExatoDiferente(x.getCodCliente(),x.getNome());
			if (c != null){
				throw new ServicoException("Já existe um cliente com esse nome!", 1);
			}*/
			
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
	
	public void excluir(Cliente x)throws ServicoException {
		try {
			x = dao.buscar(x.getCodCliente());
			if (!x.getContratos().isEmpty()){
				throw new ServicoException("Exclusão não permitida: este cliente possui contratos!", 2);
			}
			
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

	public List<Cliente> buscarPorNome(String trecho){
		return dao.buscarPorNome(trecho);
	}
	
}
