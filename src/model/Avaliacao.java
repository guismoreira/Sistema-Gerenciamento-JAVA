/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gui
 */
public class Avaliacao implements Serializable {

    private Conceito conceito;
    private Banca banca;
    private String id;

    public Avaliacao(Conceito conceito, Banca banca, String id) {
        this.conceito = conceito;
        this.banca = banca;
        this.id = id;
    }

    public void setAvaliacao(Avaliacao outro) {
        this.conceito = outro.conceito;
        this.banca = outro.banca;
        this.id = outro.id;

    }

    public Conceito getConceito() {
        return conceito;
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "conceito=" + conceito
                + banca
                + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.conceito);
        hash = 89 * hash + Objects.hashCode(this.banca);
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.conceito != other.conceito) {
            return false;
        }
        if (!Objects.equals(this.banca, other.banca)) {
            return false;
        }
        return true;
    }

}
