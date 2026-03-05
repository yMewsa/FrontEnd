package com.example.escola_xyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.escola_xyz.models.Administrador;
import com.example.escola_xyz.repository.AdministradorRepository;
import com.example.escola_xyz.repository.VerificaCadastroAdmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdministradorController {

    // Permite a transformação de um obj java em entidade de BD
    // Cada obj criado vira uma Linha do BD
    @Autowired
    AdministradorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    // Verificar Acesso e Cadastro
    boolean acessoAdm = false;

    // Métodos
    // Para navegar na Página de Cadastro
    @GetMapping("/cadastrar-adm")
    public String acessoCadastroAdmPage() {
        return "cadastro/cadastro-adm";
    }
    

    // Método para enviar o cadastro do Adm
    @PostMapping("/cadastrar-adm")
    public ModelAndView cadastrarAdmDB(Administrador adm, RedirectAttributes attributes) {
        boolean verificarCpf = vcar.existsById(adm.getCpf()); 
        ModelAndView mv = new ModelAndView("redirect:/login-adm");
        if(verificarCpf){
            // Obj. adm - pega as informções do formulario e cria um obj da classe adm
            ar.save(adm); //salva no bd
            // Cria uma mensagem para o usuário
            String mensagem = "Cadastro Realizado com Sucesso!";
            // Log para o Sistema
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem); //Leva a msg para tela de view
            attributes.addFlashAttribute("classe","verde");
        }
        else{ //Deu errado, pessoa não pode se cadastrar (Caso cpf não esteja no bd)
            String mensagem = "Cadastro não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","vermelho");
        }
        return mv;
    }
    
    // Métodos pra página de login do Adm
    @GetMapping("/login-adm")
    public String acessoLoginPageAdm() {
        return "login/login-adm";
    }
    

    // Método para carregar a página interna após o login
    @PostMapping("/acesso-adm")
    public ModelAndView acessoAdm(@RequestParam String cpf, @RequestParam String senha, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");
        boolean verificaCpf = ar.existsById(cpf); //Verifica se o cpf esta cadastro
        boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);

        if(verificaCpf && verificaSenha){
            acessoAdm = true;
        }else{
            String mensagem = "CPF ou Senha Incorreto";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","vermelho");
            mv.setViewName("redirect:/login-adm");
        }

        return mv;
    }

    // Acessar a página interna
    @GetMapping("/interna-adm")
    public ModelAndView acessoInternaPageAdm(RedirectAttributes attributes) {
        String vaiPara = ""; //Endereço do Redirecionamento
         //Model and View, vai direcionar a navegação
        if (acessoAdm){ //Verifica se o usuario esta logado
            vaiPara = "interna/interna-adm"; //Se estiver vai para a página interna
        }else{ //Caso contrário nega o acesso e redireciona para o login
            String mensagem = "Acesso não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe", "vermelha");
            vaiPara = "redirect:/login-adm";
        }
        ModelAndView mv = new ModelAndView(vaiPara);
        return mv;
    }
    
    @GetMapping("/logout-adm")
    public String logoutAdmin() {
        acessoAdm = false; //Desloga o usuário
        return "redirect:/login-adm"; //Redireciona para a página de login
    }
    
}
