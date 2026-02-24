package com.example.rh.Repository;

import org.springframework.data.repository.*;
import com.example.rh.Model.*;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    // Métodos para fazer o CRUD do Funcionario
    // Criar uma busca pela chave primaria do Funcionario
    FuncionarioRepository findById (long id);

    // Busca por nome
    FuncionarioRepository findByNome (String nome);
    
    // Busca por vários nomes (Não existe no JPA)
    @Query (value = "select u from Funcionario u where u.nome like %?1%")
    List<FuncionarioRepository> findByNomes(String nome);
}
