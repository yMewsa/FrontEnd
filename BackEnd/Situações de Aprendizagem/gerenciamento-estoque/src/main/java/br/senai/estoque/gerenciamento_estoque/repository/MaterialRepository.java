package br.senai.estoque.gerenciamento_estoque.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.senai.estoque.gerenciamento_estoque.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    
    // Busca materiais pelo nome
    List<Material> findByNomeContainingIgnoreCase(String nome);

    // Busca todos os materiais de uma categoria específica
    List<Material> findByCategoriaId(Long categoriaId);

    // JPQL Customizada: Retorna materiais cuja quantidade atual é menor ou igual à mínima
    @Query("SELECT m FROM Material m WHERE m.quantidadeAtual <= m.quantidadeMinima")
    List<Material> findMateriaisComEstoqueBaixo();
}