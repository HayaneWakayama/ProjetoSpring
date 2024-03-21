package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.Produto;

@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Produto pesquisaPeloId(Long id) {
		return entityManager.find(Produto.class, id);
	}

	@Override
	public List<Produto> lista() {
		Query query = entityManager.createQuery("SELECT p FROM Produto p");
		return query.getResultList();
	}

	@Override
	public void insere(Produto produto) {
		entityManager.persist(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		entityManager.merge(produto);
	}

	@Override
	public void remove(Produto produto) {
		entityManager.remove(produto);
		
	}
	
	
	
	
}
