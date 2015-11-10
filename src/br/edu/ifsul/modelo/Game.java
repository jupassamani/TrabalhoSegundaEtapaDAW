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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "game")
public class Game implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_game", sequenceName = "seq_game_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_game", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50,message = "O nome não deve ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O ano deve ser informado")
    @Length(max = 4,message = "O ano não deve ter mais de {max} caracteres")
    @Column(name = "ano", length = 4, nullable = false)
    private String ano;
    
    @NotBlank(message = "A jogabilidade deve ser informada")
    @Length(max = 50,message = "A jogabilidade não deve ter mais de {max} caracteres")
    @Column(name = "jogabilidade", length = 50, nullable = false)
    private String jogabilidade;
    
    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id", nullable = false)
    private Genero genero;
    
    @ManyToMany
    @JoinTable(name = "contem", 
            joinColumns = 
            @JoinColumn(name = "game", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "plataforma", referencedColumnName = "id")
            )
    private List<Plataforma> contidos = new ArrayList<>();

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Game other = (Game) obj;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getJogabilidade() {
        return jogabilidade;
    }

    public void setJogabilidade(String jogabilidade) {
        this.jogabilidade = jogabilidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public List<Plataforma> getContidos() {
        return contidos;
    }

    public void setContidos(List<Plataforma> contidos) {
        this.contidos = contidos;
    }

}
