package projetoSpring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoSpring.dao.CRUD;
import projetoSpring.dao.ProdutoDAO;
import projetoSpring.model.Produto;

@Service
public class ProdutoBO implements CRUD<Produto, Long> {
	
	@Autowired
	private ProdutoDAO dao;

	@Override
	public Produto pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Produto> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Produto produto) {
		dao.insere(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		dao.atualiza(produto);
		
	}

	@Override
	public void remove(Produto produto) {
		dao.remove(produto);
	
	}
	public void inativa(Produto produto) {
		produto.setAtivo(false);
		dao.atualiza(produto);
	}
	public void ativa(Produto produto) {
		produto.setAtivo(true);
		dao.atualiza(produto);
	}
	
}
