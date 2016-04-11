package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ClienteDao;
import dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private EntityManager em;
	
	public ClienteDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Cliente x) {
		if (x.getCodCliente() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Cliente x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Cliente buscar(int cod) {
		return em.find(Cliente.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT x FROM Cliente x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Cliente x ORDER BY x.nome";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	public Cliente buscarCpfExato(String cpf) {
		String jpql = "SELECT x FROM Cliente x WHERE x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cpf);
		List<Cliente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
		
	}
	
	
	

}
