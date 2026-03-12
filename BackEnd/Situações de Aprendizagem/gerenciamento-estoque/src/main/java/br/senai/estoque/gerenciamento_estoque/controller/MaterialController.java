package br.senai.estoque.gerenciamento_estoque.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.senai.estoque.gerenciamento_estoque.model.Material;
import br.senai.estoque.gerenciamento_estoque.repository.MaterialRepository;

@RestController
@RequestMapping("/api/materiais")
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> buscarPorId(@PathVariable Long id) {
        return materialRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para o Alerta de Estoque (RF06)
    @GetMapping("/alerta-estoque")
    public List<Material> listarEstoqueBaixo() {
        return materialRepository.findMateriaisComEstoqueBaixo();
    }

    @PostMapping
    public ResponseEntity<Material> cadastrar(@RequestBody Material material) {
        Material salvo = materialRepository.save(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> atualizar(@PathVariable Long id, @RequestBody Material materialAtualizado) {
        return materialRepository.findById(id).map(material -> {
            material.setNome(materialAtualizado.getNome());
            material.setDescricao(materialAtualizado.getDescricao());
            material.setQuantidadeMinima(materialAtualizado.getQuantidadeMinima());
            // Nota: Quantidade Atual deve ser alterada via Movimentação, não edição direta!
            Material atualizado = materialRepository.save(material);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
}