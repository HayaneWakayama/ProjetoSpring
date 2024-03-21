package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.NotaSaidaItem;

@Repository
@Transactional
public class NotaSaidaItemDAO implements CRUD<NotaSaidaItem, Long>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public NotaSaidaItem pesquisaPeloId(Long id) {
		return entityManager.find(NotaSaidaItem.class, id);
	}

	@Override
	public List<NotaSaidaItem> lista() {
		Query query = entityManager.createQuery("SELECT nsi FROM NotaSaidaItem nsi");
		return query.getResultList();
	}

	@Override
	public void insere(NotaSaidaItem notaSaidaItem) {
		entityManager.persist(notaSaidaItem);
	}

	@Override
	public void atualiza(NotaSaidaItem notaSaidaItem) {
		entityManager.merge(notaSaidaItem);
		
	}

	@Override
	public void remove(NotaSaidaItem notaSaidaItem) {
		entityManager.remove(notaSaidaItem);
		
	}
	
	public List<NotaSaidaItem> listaItensNotaSaida(Long notaSaidaId){
		Query query = entityManager.createQuery
				("FROM NotaSaidaItem n WHERE n.notaSaida.id = :notaSaidaId")
				.setParameter("notaSaidaId", notaSaidaId);
		return query.getResultList();
	}

}
