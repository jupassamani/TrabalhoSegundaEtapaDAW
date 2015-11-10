/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */
@Entity
@Table(name = "genero")
public class Genero implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_genero", sequenceName = "seq_genero_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_genero", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descricao deve ser informada")
    @Length(max = 50,message = "A descricao não deve ter mais de {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Game> games = new ArrayList<>();
  

    public Genero() {
    }
    
    public void adicionarGame(Game obj){
     //   obj.setGenero(this);
        this.games.add(obj);
    }
    
    public void removerGame(int index){
        this.games.remove(index);
    }

    @Override
    public String toString() {
        return "Genero{" + "descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
