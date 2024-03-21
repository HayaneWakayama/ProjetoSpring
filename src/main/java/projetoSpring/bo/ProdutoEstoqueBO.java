package projetoSpring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoSpring.dao.CRUD;
import projetoSpring.dao.ProdutoEstoqueDAO;
import projetoSpring.model.ProdutoEstoque;

@Service
public class ProdutoEstoqueBO implements CRUD<ProdutoEstoque, Long> {
	
	@Autowired
	private ProdutoEstoqueDAO dao;
	
	@Override
	public ProdutoEstoque pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<ProdutoEstoque> lista() {
		return dao.lista();
	}

	@Override
	public void insere(ProdutoEstoque produtoEstoque) {
		dao.insere(produtoEstoque);
	}

	@Override
	public void atualiza(ProdutoEstoque produtoEstoque) {
		dao.atualiza(produtoEstoque);
	}

	@Override
	public void remove(ProdutoEstoque produtoEstoque) {
		dao.remove(produtoEstoque);
	}



}
