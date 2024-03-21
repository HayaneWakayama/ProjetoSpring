package projetoSpring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoSpring.dao.CRUD;
import projetoSpring.dao.NotaEntradaDAO;
import projetoSpring.model.NotaEntrada;

@Service
public class NotaEntradaBO implements CRUD<NotaEntrada, Long>{

	@Autowired
	private NotaEntradaDAO notaEntradaDAO;
	
	@Override
	public NotaEntrada pesquisaPeloId(Long id) {
		return notaEntradaDAO.pesquisaPeloId(id);
	}

	@Override
	public List<NotaEntrada> lista() {
		return notaEntradaDAO.lista();
	}

	@Override
	public void insere(NotaEntrada notaEntrada) {
		notaEntradaDAO.insere(notaEntrada);
	}

	@Override
	public void atualiza(NotaEntrada notaEntrada) {
		notaEntradaDAO.atualiza(notaEntrada);
	}

	@Override
	public void remove(NotaEntrada notaEntrada) {
		notaEntradaDAO.remove(notaEntrada);
	}
	
	

}
