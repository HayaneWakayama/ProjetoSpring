package projetoSpring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import projetoSpring.model.NotaEntradaItem;

@Repository
@Transactional
public class NotaEntradaItemDAO implements CRUD<NotaEntradaItem, Long >{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public NotaEntradaItem pesquisaPeloId(Long id) {
		return entityManager.find(NotaEntradaItem.class, id) ;
	}

	@Override
	public List<NotaEntradaItem> lista() {
		Query query = entityManager.createQuery("SELECT nei FROM NotaEntradaItem nei");
		return query.getResultList();		
	}

	@Override
	public void insere(NotaEntradaItem notaEntradaItem) {
		entityManager.persist(notaEntradaItem);
	}

	@Override
	public void atualiza(NotaEntradaItem notaEntradaItem) {
		entityManager.merge(notaEntradaItem);
	}

	@Override
	public void remove(NotaEntradaItem notaEntradaItem) {
		entityManager.remove(notaEntradaItem);
	}
	
	//retorna todos os itens vinculados a uma nota de entrada
	public List<NotaEntradaItem> listaItensNota(Long notaEntradaId){
		Query query = entityManager.createQuery
				("FROM NotaEntradaItem n WHERE n.notaEntrada.id = :notaEntradaId")
				.setParameter("notaEntradaId", notaEntradaId);
		return query.getResultList();
				
			
	}

}
