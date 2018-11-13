package br.com.apsAnhembi.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuracao {
	String idUsuario;
	String chave;
	String valor;

	public Configuracao(String idUsuario, String chave, String valor) {
		super();
		this.idUsuario = idUsuario;
		this.chave = chave;
		this.valor = valor;
	}

	public Configuracao() {
		super();
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
