package br.com.apsAnhembi.repository.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ConfiguracaoEntityPK implements Serializable {

    private static final long serialVersionUID = 1L;
    String idUsuario;
    String chave;

    public ConfiguracaoEntityPK() {
    }

    public ConfiguracaoEntityPK(String idUsuario, String chave) {
        this.idUsuario = idUsuario;
        this.chave = chave;
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
}
