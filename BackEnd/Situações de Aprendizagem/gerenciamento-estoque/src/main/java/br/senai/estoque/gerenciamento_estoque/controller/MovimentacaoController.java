package br.senai.estoque.gerenciamento_estoque.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.senai.estoque.gerenciamento_estoque.model.Movimentacao;
import br.senai.estoque.gerenciamento_estoque.model.Material;
import br.senai.estoque.gerenciamento_estoque.model.TipoMovimentacao;
import br.senai.estoque.gerenciamento_estoque.repository.MaterialRepository;
import br.senai.estoque.gerenciamento_estoque.repository.MovimentacaoRepository;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public List<Movimentacao> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    @Transactional // Garante que se der erro na movimentação, o estoque não é alterado (Rollback)
    public ResponseEntity<Object> registrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        
        // 1. Busca o material no banco
        Material material = materialRepository.findById(movimentacao.getMaterial().getId()).orElse(null);
        
        if (material == null) {
            return ResponseEntity.badRequest().body("Material não encontrado.");
        }

        // 2. Calcula a nova quantidade
        int quantidadeAtual = material.getQuantidadeAtual();
        int quantidadeMovimentada = movimentacao.getQuantidade();

        if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
            material.setQuantidadeAtual(quantidadeAtual + quantidadeMovimentada);
        } else if (movimentacao.getTipo() == TipoMovimentacao.SAIDA) {
            if (quantidadeAtual < quantidadeMovimentada) {
                return ResponseEntity.badRequest().body("Estoque insuficiente para a saída solicitada.");
            }
            material.setQuantidadeAtual(quantidadeAtual - quantidadeMovimentada);
        }

        // 3. Salva a atualização do material e registra a movimentação
        materialRepository.save(material);
        Movimentacao salva = movimentacaoRepository.save(movimentacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}