package com.example.escola_xyz.models;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class VerificaCadastroAdmin implements Serializable{
    // Atributos
    @Id
    private String cpf;
    private String nome;
    
    // Métodos - Getters and Setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
