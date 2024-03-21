package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.ProdutoEstoque;

@Repository
@Transactional
public class ProdutoEstoqueDAO implements CRUD<ProdutoEstoque, Long> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ProdutoEstoque pesquisaPeloId(Long id) {
		return entityManager.find(ProdutoEstoque.class, id);
	}

	@Override
	public List<ProdutoEstoque> lista() {
		Query query = entityManager.createQuery("SELECT pe FROM ProdutoEstoque pe");
		return query.getResultList();
	}

	@Override
	public void insere(ProdutoEstoque produtoEstoque) {
		entityManager.persist(produtoEstoque);
	}

	@Override
	public void atualiza(ProdutoEstoque produtoEstoque) {
		entityManager.merge(produtoEstoque);
		
	}

	@Override
	public void remove(ProdutoEstoque produtoEstoque) {
		entityManager.remove(produtoEstoque);
		
	}
	
}
