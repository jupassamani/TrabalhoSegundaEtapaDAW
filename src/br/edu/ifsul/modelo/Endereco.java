/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A rua deve ser informada")
    @Length(max = 50,message = "A rua não deve ter mais de {max} caracteres")
    @Column(name = "rua", length = 50, nullable = false)
    private String rua;
    
    @NotNull(message = "O complemento deve ser informado")
    @NotBlank(message = "O complemento não pode ficar em branco")
    @Length(max = 30, message = "O complemento não pode ter mais de {max} caracteres")
    @Column(name = "complemento", length = 30, nullable = false) 
    private String complemento;
    
    @NotNull(message = "O bairro deve ser informado")
    @NotBlank(message = "O bairro não pode ficar em branco")
    @Length(max = 30, message = "O bairro não pode ter mais de {max} caracteres")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    
    @NotNull(message = "O cep deve ser informado")
    @NotBlank(message = "O cep não pode ficar em branco")
    @Length(max = 9, message = "O cep não pode ter mais de {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)      
    private String cep;
    
    @NotNull(message = "A cidade deve ser informada")
    @NotBlank(message = "A cidade não pode ficar em branco")
    @Length(max = 30, message = "A cidade não pode ter mais de {max} caracteres")
    @Column(name = "cidade", length = 30, nullable = false)
    private String cidade;
    
    @NotNull(message = "O estado deve ser informado")
    @NotBlank(message = "O estado não pode ficar em branco")
    @Length(max = 30, message = "O estado não pode ter mais de {max} caracteres")
    @Column(name = "estado", length = 30, nullable = false)
    private String Estado;

    public Endereco() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
