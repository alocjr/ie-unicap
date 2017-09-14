/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tj
 */
@Entity
@NamedQueries({
    @NamedQuery(name="InstituicaoEnsino.filterByDescription", query="select ie from InstituicaoEnsino ie where ie.descricao like :descricao ORDER BY ie.descricao ASC")
})
@Table(name = "tb_ie")
public class InstituicaoEnsino implements Serializable {
    
    public static final String FILTER_BY_DESCRIPTION = "InstituicaoEnsino.filterByDescription";
    public static final String FILTER_PARAM = "descricao";
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    public InstituicaoEnsino() {
    }

    public InstituicaoEnsino(Long id, String descricao) {
        this(descricao);
        this.id = id;

    }

    public InstituicaoEnsino(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof InstituicaoEnsino)) {
            return false;
        }
        InstituicaoEnsino other = (InstituicaoEnsino) object;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "br.unicap.ie.InstituicaoEnsino[ id=" + id + ", descricao=" + descricao + " ]";
    }
}
