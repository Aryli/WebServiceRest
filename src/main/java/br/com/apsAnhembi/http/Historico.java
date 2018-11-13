package br.com.apsAnhembi.http;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Historico {

	int id;
	int idLocal;
	String entrada;
	String saida;

	public Historico(int id, int idLocal, String entrada, String saida) {
		this.id = id;
		this.idLocal = idLocal;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Historico() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getEntrada() {
		return entrada;
	}

//	public void setEntrada(Date entrada) {
//		this.entrada = entrada;
//	}
//	public void setSaida(Date saida) {
//		this.saida = saida;
//	}
	public void setEntrada(String entrada) throws ParseException {
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) throws ParseException {
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.saida = saida;
	}

}
