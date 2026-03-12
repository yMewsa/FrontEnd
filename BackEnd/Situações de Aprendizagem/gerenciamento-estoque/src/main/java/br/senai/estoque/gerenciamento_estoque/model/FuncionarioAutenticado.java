package br.senai.estoque.gerenciamento_estoque.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "funcionarios_autenticados")
public class FuncionarioAutenticado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 20)
    private String nif;

    @Column(nullable = false)
    private boolean ativo = true;

}
