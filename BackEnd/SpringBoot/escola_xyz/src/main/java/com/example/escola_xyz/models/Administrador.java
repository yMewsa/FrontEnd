package com.example.escola_xyz.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Classe conectiva ao BD - Entidade do Banco
// Serializable - converte para binario (permite transcrever para SQL)
@Entity
public class Administrador implements Serializable{
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    // Getters and Setters
    // Criação pela lampada
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
