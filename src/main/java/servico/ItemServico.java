package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemDao;
import dao.Transaction;
import dominio.Item;
import dominio.Pacote;

public class ItemServico {

private ItemDao dao;
	
	public ItemServico() {
		dao = DaoFactory.criarItemDao();
	}
	
	
	public void inserir(Item x) throws ServicoException {
		
		Pacote pac = x.getPacote();
		for (Item it : pac.getItens()) {
			if (it.getPasseio().equals(x.getPasseio())) {
				throw new ServicoException("Este passeio já pertence ao pacote!", 1);
			}
		}

		try {
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
	
	/*public void atualizar(Item x)throws ServicoException {
		Item aux = dao.buscarExatoDiferente(x.getCodPasseio(), x.getPacote());
		if (aux != null){
			throw new ServicoException("Este" + "passeio" +x.getPasseio().getNome()+ " já esta cadastrado no" +"pacote"+ x.getPacote().getNome(), 1);
		}
		try {
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
	}*/
	
	public void excluir(Item x){
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
	
	public Item buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Item> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
