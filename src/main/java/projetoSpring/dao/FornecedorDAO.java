package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.Fornecedor;

@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Fornecedor pesquisaPeloId(Long id) {
		return entityManager.find(Fornecedor.class, id);
	}

	@Override
	public List<Fornecedor> lista() {
		Query query = entityManager.createQuery("SELECT f FROM Fornecedor f");
		return query.getResultList();
	}

	@Override
	public void insere(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);
	}

	@Override
	public void atualiza(Fornecedor fornecedor) {
		entityManager.merge(fornecedor);
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		entityManager.remove(fornecedor);
	}

}
