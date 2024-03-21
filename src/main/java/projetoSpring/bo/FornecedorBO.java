package projetoSpring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoSpring.dao.CRUD;
import projetoSpring.dao.FornecedorDAO;
import projetoSpring.model.Fornecedor;

@Service
public class FornecedorBO implements CRUD<Fornecedor, Long> {
	
	@Autowired
	private FornecedorDAO dao;

	@Override
	public Fornecedor pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Fornecedor> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Fornecedor fornecedor) {
		dao.insere(fornecedor);
	}

	@Override
	public void atualiza(Fornecedor fornecedor) {
		dao.atualiza(fornecedor);
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		dao.remove(fornecedor);
	}
	
	public void inativa(Fornecedor fornecedor) {
		fornecedor.setAtivo(false);
		dao.atualiza(fornecedor);
	}
	
	public void ativa(Fornecedor fornecedor) {
		fornecedor.setAtivo(true);
		dao.atualiza(fornecedor);
	}
	
}
