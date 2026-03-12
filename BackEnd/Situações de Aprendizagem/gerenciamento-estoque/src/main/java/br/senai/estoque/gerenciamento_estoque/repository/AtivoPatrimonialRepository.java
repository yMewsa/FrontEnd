package br.senai.estoque.gerenciamento_estoque.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.estoque.gerenciamento_estoque.model.AtivoPatrimonial;

public interface AtivoPatrimonialRepository extends JpaRepository<AtivoPatrimonial, Long> {
    
    // Busca um ativo exato pelo número da plaqueta do SENAI
    Optional<AtivoPatrimonial> findByNumeroTombamento(String numeroTombamento);

    // Busca todos os equipamentos de um determinado local (ex: "Laboratório de TI")
    List<AtivoPatrimonial> findByLocalizacaoContainingIgnoreCase(String localizacao);

    // Busca equipamentos por estado (ex: "EM MANUTENÇÃO")
    List<AtivoPatrimonial> findByEstadoConservacaoIgnoreCase(String estado);
}