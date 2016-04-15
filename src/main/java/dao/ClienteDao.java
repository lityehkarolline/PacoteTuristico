package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	
	public void inserirAtualizar(Cliente x);
	public void excluir(Cliente x);
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	
	public List<Cliente> buscarTodosOrdenadosPorNome();
	
	public Cliente buscarCpfExato(String cpf);
	
	public Cliente buscarCpfExatoDiferente(Integer codigo, String cpf);
	
	public Cliente buscarNomeExato(String nome);
	
	public Cliente buscarNomeExatoDiferente(Integer codigo, String nome);
	
	public List<Cliente> buscarPorNome(String trecho);
}
