package projetoUninter.bo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.transaction.Transactional;
import projetoSpring.ProjetoSpringApplication;
import projetoSpring.bo.ProdutoBO;
import projetoSpring.model.Categoria;
import projetoSpring.model.Produto;

@SpringBootTest (classes = ProjetoSpringApplication.class) 
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@Transactional
public class ProdutoBOTest {
	
	@Autowired
	private ProdutoBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Produto produto = new Produto();
		produto.setNome("Produto 1");
		produto.setCategoria(Categoria.CELULARES);
		produto.setAtivo(true);
	
	}
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Produto produto = bo.pesquisaPeloId(1L);
		System.out.println(produto);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Produto produto = bo.pesquisaPeloId(1L);
		produto.setCategoria(Categoria.ELETRODOMESTICO);
		bo.atualiza(produto);
	
	}
	
	@Test
	@Order(4)
	public void lista() {
		List<Produto> produtos = bo.lista();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}
	
	@Test
	@Order(5)
	public void inativa() {
		Produto produto = bo.pesquisaPeloId(2L);
		bo.inativa(produto);
	}
	
	@Test
	@Order(6)
	public void remove() {
		Produto produto = bo.pesquisaPeloId(2L);
		bo.remove(produto);
	}
}