package br.senai.estoque.gerenciamento_estoque.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "ativos_patrimoniais")
public class AtivoPatrimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroTombamento; // Plaqueta do SENAI

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 100)
    private String numeroSerie;

    @Column(nullable = false, length = 50)
    private String estadoConservacao; 

    @Column(nullable = false, length = 100)
    private String localizacao; 

    @Column(name = "data_aquisicao")
    private LocalDate dataAquisicao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroTombamento() { return numeroTombamento; }
    public void setNumeroTombamento(String numeroTombamento) { this.numeroTombamento = numeroTombamento; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public String getEstadoConservacao() { return estadoConservacao; }
    public void setEstadoConservacao(String estadoConservacao) { this.estadoConservacao = estadoConservacao; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public LocalDate getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(LocalDate dataAquisicao) { this.dataAquisicao = dataAquisicao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
