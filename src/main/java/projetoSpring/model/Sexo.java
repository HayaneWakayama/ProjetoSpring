package projetoSpring.model;

public enum Sexo {
	MASCULINO("Masculiono"),
	FEMININO("Feminino");
	
	private String descricao;
	
	Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
