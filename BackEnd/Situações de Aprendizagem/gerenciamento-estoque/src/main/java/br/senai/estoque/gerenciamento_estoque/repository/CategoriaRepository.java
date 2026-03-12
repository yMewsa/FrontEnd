package br.senai.estoque.gerenciamento_estoque.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.estoque.gerenciamento_estoque.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Busca categorias ignorando letras maiúsculas/minúsculas (útil para barras de pesquisa)
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}