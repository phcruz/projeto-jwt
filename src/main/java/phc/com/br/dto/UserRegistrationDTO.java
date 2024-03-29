package phc.com.br.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import phc.com.br.model.User;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDTO extends User {

	private Long id;

	private String nome;
	private String email;
	private String senha;

	public UserRegistrationDTO() {

	}

	public UserRegistrationDTO(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public User toUser() {
		return new User(getNome(), getEmail(), getSenha());
	}

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

}
