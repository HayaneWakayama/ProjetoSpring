package projetoUninter.bo;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.transaction.Transactional;
import projetoSpring.ProjetoSpringApplication;
import projetoSpring.bo.FornecedorBO;
import projetoSpring.model.Fornecedor;

@SpringBootTest (classes = ProjetoSpringApplication.class)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@Transactional
public class FornecedorBOTest {
	
	@Autowired
	private FornecedorBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFantasia("Fornecedor 1");
		fornecedor.setCnpj("09848054000186");
		fornecedor.setRazaoSocial("Fornecedor LTDA");
		fornecedor.setTelefone("1122223333");
		fornecedor.setCelular("1144445555");
		fornecedor.setEmail("japandev@gmail.com");
		fornecedor.setAtivo(true);
		bo.insere(fornecedor);;
	}
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		System.out.println(fornecedor);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		fornecedor.setCelular("7788889999");
		bo.atualiza(fornecedor);
	}
	
	@Test
	@Order(4)
	public void lista() {
		List<Fornecedor> fornecedores = bo.lista();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Order(5)
	public void inativa() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.inativa(fornecedor);
	}
	
	@Test
	@Order(6)
	public void remove() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.remove(fornecedor);
	}


}
