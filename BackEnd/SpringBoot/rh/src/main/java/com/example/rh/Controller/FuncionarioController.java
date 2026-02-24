package com.example.rh.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.example.rh.Repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.rh.Model.Funcionario;

@Controller
public class FuncionarioController {
    // Atributo
    @Autowired
    private FuncionarioRepository fr;
    
    // Quando /funcionario for digitado na barra de endereço, o site sera direcionado para a página de cadastro funcionario
    @RequestMapping (value="/funcionario", method=RequestMethod.GET)
    public String abrirFuncionario(@RequestParam String param) {
        return "funcionario/funcionario";
    }

    // Requisição para cadastrar funcionários no banco
    @RequestMapping (value = "/funcionario", method = RequestMethod.POST)
    public String gravarFuncionario (Funcionario funcionario){
        fr.save(funcionario);
        return "redirect:/funcionario";
    }
}
