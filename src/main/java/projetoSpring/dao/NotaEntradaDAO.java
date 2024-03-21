package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.NotaEntrada;

@Repository
@Transactional
public class NotaEntradaDAO implements CRUD<NotaEntrada, Long>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public NotaEntrada pesquisaPeloId(Long id) {
		return entityManager.find(NotaEntrada.class, id);
	}

	@Override
	public List<NotaEntrada> lista() {
		Query query = entityManager.createQuery("SELECT ne FROM NotaEntrada ne");
		return query.getResultList();
	}

	@Override
	public void insere(NotaEntrada notaEntrada) {
		entityManager.persist(notaEntrada);
	}

	@Override
	public void atualiza(NotaEntrada notaEntrada) {
		entityManager.merge(notaEntrada);
	}

	@Override
	public void remove(NotaEntrada notaEntrada) {
		entityManager.remove(notaEntrada);
	}
	
	

}
