/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */

@Entity
@Table(name = "plataforma")
public class Plataforma {
    @Id
    @SequenceGenerator(name = "seq_plataforma", sequenceName = "seq_plataforma_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_plataforma", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private String fabricante;
    private String tipo_midia;
    @ManyToMany
    @JoinTable(name = "contem", joinColumns = 
            @JoinColumn(name = "plataforma", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "game", referencedColumnName = "id")
            )
    private List<Game> contem = new ArrayList<>();
    
    public Plataforma() {
    }

    @Override
    public String toString() {
        return "Plataforma{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plataforma other = (Plataforma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Game> getContem() {
        return contem;
    }

    public void setContem(List<Game> contem) {
        this.contem = contem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo_midia() {
        return tipo_midia;
    }

    public void setTipo_midia(String tipo_midia) {
        this.tipo_midia = tipo_midia;
    }

}
