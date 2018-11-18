package br.com.apsAnhembi.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracao")
public class ConfiguracaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private ConfiguracaoEntityPK id;

    @Column(name = "valor")
    private String valor;

    public ConfiguracaoEntityPK getId() {
        return id;
    }

    public void setId(ConfiguracaoEntityPK id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
