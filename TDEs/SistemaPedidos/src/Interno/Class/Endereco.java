package Interno.Class;

import java.io.Serializable;

public class Endereco implements Serializable {
	private String rua;
	private String numero;
	private String complmento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	public Endereco() {

	}

	//construtor para teste
	public Endereco(String rua, String numero, String complemento, String bairro, String cep, String cidade,
			String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complmento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplmento(String complmento) {
		this.complmento = complmento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplmento() {
		return complmento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}
