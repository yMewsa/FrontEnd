package br.senai.estoque.gerenciamento_estoque.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.senai.estoque.gerenciamento_estoque.model.AtivoPatrimonial;
import br.senai.estoque.gerenciamento_estoque.repository.AtivoPatrimonialRepository;

@RestController
@RequestMapping("/api/ativos")
public class AtivoPatrimonialController {

    @Autowired
    private AtivoPatrimonialRepository ativoRepository;

    @GetMapping
    public List<AtivoPatrimonial> listarTodos() {
        return ativoRepository.findAll();
    }

    @GetMapping("/tombamento/{numero}")
    public ResponseEntity<AtivoPatrimonial> buscarPorTombamento(@PathVariable String numero) {
        return ativoRepository.findByNumeroTombamento(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtivoPatrimonial> cadastrar(@RequestBody AtivoPatrimonial ativo) {
        AtivoPatrimonial salvo = ativoRepository.save(ativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}/localizacao")
    public ResponseEntity<AtivoPatrimonial> transferirLocal(@PathVariable Long id, @RequestBody String novaLocalizacao) {
        return ativoRepository.findById(id).map(ativo -> {
            ativo.setLocalizacao(novaLocalizacao);
            AtivoPatrimonial atualizado = ativoRepository.save(ativo);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
}