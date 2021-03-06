package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PasseioDao;
import dominio.Passeio;

public class PasseioDaoImpl implements PasseioDao {

	private EntityManager em;
	
	public PasseioDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Passeio x) {
		if (x.getCodPasseio() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Passeio x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Passeio buscar(int cod) {
		return em.find(Passeio.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Passeio> buscarTodos() {
		String jpql = "SELECT x FROM Passeio x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	 public List<Passeio> buscarPorCidade(String trecho) {
		String jpql = "SELECT x FROM Passeio x WHERE x.cidade LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}

}
