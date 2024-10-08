package br.com.ufape.agiota.model.autenticacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import br.com.ufape.agiota.exceptions.CepInvalidoException;
import br.com.ufape.agiota.exceptions.CepValidator;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cep;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(){}

	public Endereco(String cep, String numero, String rua, String bairro, String cidade, String estado) throws CepInvalidoException{
		CepValidator.validar(cep);
		this.cep = cep;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		CepValidator.validar(cep);
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
