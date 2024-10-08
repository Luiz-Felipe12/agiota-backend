package br.com.ufape.agiota.model.autenticacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import br.com.ufape.agiota.exceptions.EmailInvalidoException;
import br.com.ufape.agiota.exceptions.EmailValidator;
import br.com.ufape.agiota.exceptions.SenhaInvalidaException;
import br.com.ufape.agiota.exceptions.SenhaValidator;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;
	private String senha;

	public Login() {
	}

	public Login(String email, String senha) throws EmailInvalidoException,SenhaInvalidaException {
		EmailValidator.validar(email);
		SenhaValidator.validar(senha);
		this.email = email.toLowerCase();
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		EmailValidator.validar(email);
		this.email = email.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		SenhaValidator.validar(senha);
		this.senha = senha;
	}

}
