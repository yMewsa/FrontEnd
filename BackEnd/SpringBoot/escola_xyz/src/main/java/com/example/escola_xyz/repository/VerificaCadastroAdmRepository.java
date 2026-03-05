package com.example.escola_xyz.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.escola_xyz.models.VerificaCadastroAdmin;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdmin,String>{
    VerificaCadastroAdmin findByCpf(String cpf);    
}
