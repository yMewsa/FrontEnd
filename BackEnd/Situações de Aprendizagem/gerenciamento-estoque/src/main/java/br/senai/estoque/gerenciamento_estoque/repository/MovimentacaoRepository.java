package br.senai.estoque.gerenciamento_estoque.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.estoque.gerenciamento_estoque.model.Movimentacao;
import br.senai.estoque.gerenciamento_estoque.model.TipoMovimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
    // Busca todo o histórico de um material específico, ordenado da data mais recente para a mais antiga
    List<Movimentacao> findByMaterialIdOrderByDataHoraDesc(Long materialId);

    // Busca apenas as Entradas ou apenas as Saídas
    List<Movimentacao> findByTipoOrderByDataHoraDesc(TipoMovimentacao tipo);
}