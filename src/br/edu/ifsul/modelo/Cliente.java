/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */

@Entity
@Table(name = "cliente")
public abstract class Cliente implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome deve ser informado!")    
    @NotBlank(message = "O nome nao pode ficar em branco!")
    @Length(max = 50, message = "O nome nao pode ter mais de {max} caracteres.")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O CPF deve ser informado!")    
    @NotBlank(message = "O CPF nao pode ficar em branco!")
    @Length(max = 20, message = "O CPF nao pode ter mais de {max} caracteres.")
    @Column(name = "CPF", length = 20, nullable = false)
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    
    @NotNull(message = "O RG deve ser informado")
    @NotBlank(message = "O RG não pode ficar em branco")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    @Column(name = "RG", length = 10, nullable = false)      
    private String rg;
    
    @NotNull(message = "A data de nascimento deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotNull(message = "O email deve ser informado!")    
    @NotBlank(message = "O email nao pode ficar em branco!")
    @Length(max = 50, message = "O email nao pode ter mais de {max} caracteres.")
    @Column(name = "email", length = 50, nullable = false)
    @Email(message = "O email deve ser valido")
    private String email;
    
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    
    @NotNull(message = "O endereco deve ser informado")
    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    public Cliente() {
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + '}';
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
    
    
}
