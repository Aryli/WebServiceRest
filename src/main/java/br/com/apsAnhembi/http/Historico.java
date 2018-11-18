package br.com.apsAnhembi.http;

import java.text.ParseException;

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

    public void setEntrada(String entrada) throws ParseException {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) throws ParseException {
        this.saida = saida;
    }

}
