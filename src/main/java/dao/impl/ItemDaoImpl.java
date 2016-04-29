package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemDao;
import dominio.Item;

public class ItemDaoImpl implements ItemDao {

	private EntityManager em;
	
	public ItemDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Item x) {
		if (x.getCodItem() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Item x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Item buscar(int cod) {
		return em.find(Item.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> buscarTodos() {
		String jpql = "SELECT x FROM Item x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Item buscarExato(Integer codItem, Passeio passeio, Pacote pacote){

		String jpql = "SELECT x FROM Item x WHERE x.codItem = :p0 AND x.passeio = :p1 AND x.pacote = :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codItem);
		query.setParameter("p1", passeio);
		query.setParameter("p2", pacote);
		List<Item> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}*/
	

}
