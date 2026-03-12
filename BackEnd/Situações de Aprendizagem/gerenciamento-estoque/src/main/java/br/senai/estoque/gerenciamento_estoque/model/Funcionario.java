package br.senai.estoque.gerenciamento_estoque.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    private String nif;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
	private boolean ativo = true;
}
