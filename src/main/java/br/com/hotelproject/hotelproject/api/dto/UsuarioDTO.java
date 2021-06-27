package br.com.hotelproject.hotelproject.api.dto;

public class UsuarioDTO {
	
	protected String nome;
	protected String email;
	protected String senha;
	protected int idade;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String nome, String email, String senha, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
