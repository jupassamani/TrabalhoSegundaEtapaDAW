/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;


/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */
public class Game {
    private Integer id;
    private String nome;
    private String ano;
    private String jogabilidade;

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

}
