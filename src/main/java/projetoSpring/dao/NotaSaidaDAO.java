package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.NotaSaida;

@Repository
@Transactional
public class NotaSaidaDAO implements CRUD<NotaSaida, Long>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public NotaSaida pesquisaPeloId(Long id) {
		return entityManager.find(NotaSaida.class, id);
	}

	@Override
	public List<NotaSaida> lista() {
		Query query = entityManager.createQuery("SELECT ns FROM NotaSaida ns");
		return query.getResultList();
	}

	@Override
	public void insere(NotaSaida notaSaida) {
		entityManager.persist(notaSaida);
		
	}

	@Override
	public void atualiza(NotaSaida notaSaida) {
		entityManager.merge(notaSaida);
		
	}

	@Override
	public void remove(NotaSaida notaSaida) {
		entityManager.remove(notaSaida);
		
	}
	

}
