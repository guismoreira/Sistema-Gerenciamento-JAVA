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
public class Professor implements Serializable {

    private String nome;
    private String email;
    private AreaInteresse areaInteresse;
    private String sugestaoProj;
    private String id;

    public Professor(String nome, String email, AreaInteresse areaInteresse, String sugestaoProj, String id) {
        this.nome = nome;
        this.email = email;
        this.areaInteresse = areaInteresse;
        this.sugestaoProj = sugestaoProj;
        this.id = id;
    }

    public void setProfessor(Professor outro) {
        this.nome = outro.nome;
        this.email = outro.email;
        this.areaInteresse = outro.areaInteresse;
        this.sugestaoProj = outro.sugestaoProj;
        this.id = outro.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AreaInteresse getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(AreaInteresse areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

    public String getSugestaoProj() {
        return sugestaoProj;
    }

    public void setSugestaoProj(String sugestaoProj) {
        this.sugestaoProj = sugestaoProj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Professor -> " + "nome=" + nome + ", email=" + email + ", area de interesse=" + areaInteresse
                + ", sugestao de projeto=" + sugestaoProj + ", id prof =" + id + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.areaInteresse);
        hash = 53 * hash + Objects.hashCode(this.sugestaoProj);
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.areaInteresse, other.areaInteresse)) {
            return false;
        }
        if (!Objects.equals(this.sugestaoProj, other.sugestaoProj)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
