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
 * @author Gui
 */
public class Banca implements Serializable {

    private Professor avaliador1;
    private Professor avaliador2;
    Proposta proposta;
    private String id;

    public Banca(Professor avaliador1, Professor avaliador2, Proposta proposta, String id) {
        this.avaliador1 = avaliador1;
        this.avaliador2 = avaliador2;
        this.proposta = proposta;
        this.id = id;

    }

    public Professor getAvaliador1() {
        return avaliador1;
    }

    public void setAvaliador1(Professor avaliador1) {
        this.avaliador1 = avaliador1;
    }

    public Professor getAvaliador2() {
        return avaliador2;
    }

    public void setAvaliador2(Professor avaliador2) {
        this.avaliador2 = avaliador2;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBanca(Banca outro) {
        this.avaliador1 = outro.avaliador1;
        this.avaliador2 = outro.avaliador2;
        this.id = outro.id;

    }

    @Override
    public String toString() {
        return "\n" + "BANCA AVALIADORA / Definição de Professor Orientador e Tema:" + "\n" + "Avaliador 1 =" + avaliador1.getNome() + "\n" + "Avaliador 2 = " + avaliador2.getNome()
                + "\n" + proposta + ", id banca = " + id + "\n" + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.avaliador1);
        hash = 97 * hash + Objects.hashCode(this.avaliador2);
        hash = 97 * hash + Objects.hashCode(this.proposta);
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Banca other = (Banca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.avaliador1, other.avaliador1)) {
            return false;
        }
        if (!Objects.equals(this.avaliador2, other.avaliador2)) {
            return false;
        }
        if (!Objects.equals(this.proposta, other.proposta)) {
            return false;
        }
        return true;
    }

}
