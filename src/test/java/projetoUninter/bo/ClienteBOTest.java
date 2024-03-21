package projetoUninter.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import jakarta.transaction.Transactional;
import projetoSpring.ProjetoSpringApplication;
import projetoSpring.bo.ClienteBO;
import projetoSpring.model.Cliente;
import projetoSpring.model.Sexo;


@SpringBootTest (classes = ProjetoSpringApplication.class)
@ExtendWith(SpringExtension.class) 
@TestMethodOrder(OrderAnnotation.class) 
@Transactional
public class ClienteBOTest {
	
	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("Cliente Teste");
		cliente.setCpf("638.970.390-28");
		cliente.setDataDeNascimento(LocalDate.of(1963, 01, 8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("8100000001");
		cliente.setCelular("8122222222");
		cliente.setEmail("cliente@gmail.com");
		cliente.setAtivo(true);
		bo.insere(cliente);
	}
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(2L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(2L);
		cliente.setCpf("525.511.490-10");
		bo.atualiza(cliente);
	
	}
	
	@Test
	@Order(4)
	public void lista() {
		List<Cliente> clientes = bo.lista();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	@Test
	@Order(5)
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(2L);
		bo.inativa(cliente);
	}
	
	@Test
	@Order(6)
	public void remove() {
		Cliente cliente = bo.pesquisaPeloId(2L);
		bo.remove(cliente);
	}
	
}
