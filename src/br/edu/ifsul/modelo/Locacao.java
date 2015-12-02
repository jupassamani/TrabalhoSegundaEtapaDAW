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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */

@Entity
@Table(name = "locacao")
public class Locacao implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_locacao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O status deve ser informado")
    private Boolean status;
    
    @NotNull(message = "A data de retirada deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_retirada", nullable = false)
    private Calendar data_retirada;
    
    @NotNull(message = "A data de entrega deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrega", nullable = false)
    private Calendar data_entrega;

    public Locacao() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Locacao other = (Locacao) obj;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Calendar getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Calendar data_retirada) {
        this.data_retirada = data_retirada;
    }

    public Calendar getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Calendar data_entrega) {
        this.data_entrega = data_entrega;
    }

}
