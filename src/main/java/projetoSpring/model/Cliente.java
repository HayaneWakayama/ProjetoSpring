package projetoSpring.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="clientes")
public class Cliente {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //sempre que salvar um cliente a chave primária será gerada automaticamente
	private Long id;
	
	@Column(nullable=false, length = 50) //nullable=false para que o nome seja obrigatório
	@NotBlank(message = "Informe o nome")
	@Size(min = 3, max = 50)
	private String nome;
	
	@Column(length  = 14)
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  //se fosse data e hora TIMESTAMP
	@Column(name="data_nascimento", columnDefinition = "DATE")
	@NotNull(message = "Informe a data de nascimento")
	private LocalDate dataDeNascimento;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Informe o sexo")
	private Sexo sexo;
	
	@Column(length  = 14)
	private String telefone;
	
	@Column(length  = 15)
	private String celular;
	
	@Column(length = 50)
	@Email
	private String email;
	
	private boolean ativo;
	
	public Cliente( ) {
		this.ativo = true;
	}
	
	//Declarar Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf != null ? cpf.replaceAll("[^0-9]", "") : null;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento
				+ ", sexo=" + sexo + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + ", ativo="
				+ ativo + "]";
	}
	
	
	
}
