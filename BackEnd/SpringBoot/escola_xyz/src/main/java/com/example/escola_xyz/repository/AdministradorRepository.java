package com.example.escola_xyz.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.escola_xyz.models.Administrador;


// Extends - Criação de Herança
public interface AdministradorRepository extends CrudRepository<Administrador,String>{
    // Caso precise criar um método especifico de busca no BD
    Administrador findByCpf(String cpf);
}
