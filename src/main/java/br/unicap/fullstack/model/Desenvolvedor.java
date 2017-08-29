/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.model;

import java.io.Serializable;

/**
 *
 * @author tj
 */
public class Desenvolvedor implements Serializable {
    
    private int id;
    private String nome;
    private float salario;

    public Desenvolvedor() {
    }
    
    public Desenvolvedor(int id, String nome, float salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    @Override
    public int hashCode(){
        return this.id;
    }
    
    @Override
    public boolean equals(Object d){
        return d.hashCode() == this.hashCode();
    }
    
    
}
