package phc.com.br.dto;

import phc.com.br.model.User;

public class UserAutheticatedDTO {

	private String tipo;
	private String email;
	private String nome;
	private String token;

	public UserAutheticatedDTO() {
	}

	public UserAutheticatedDTO(String email, String nome, String token, String tipo) {
		this.email = email;
		this.nome = nome;
		this.token = token;
		this.tipo = tipo;
	}

	public static UserAutheticatedDTO toDTO(User user, String tipo) {
		return new UserAutheticatedDTO(user.getEmail(), user.getNome(), user.getToken(), tipo);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
