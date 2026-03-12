package br.senai.estoque.gerenciamento_estoque.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo; // entrada ou saida

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @Column(length = 255)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionarioResponsavel;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoMovimentacao getTipo() { return tipo; }
    public void setTipo(TipoMovimentacao tipo) { this.tipo = tipo; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { this.material = material; }

    public Funcionario getFuncionarioResponsavel() { return funcionarioResponsavel; }
    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) { this.funcionarioResponsavel = funcionarioResponsavel; }
}