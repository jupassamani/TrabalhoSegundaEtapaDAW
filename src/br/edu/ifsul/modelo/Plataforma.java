/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
