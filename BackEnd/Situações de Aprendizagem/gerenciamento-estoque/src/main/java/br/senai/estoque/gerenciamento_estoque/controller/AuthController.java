package br.senai.estoque.gerenciamento_estoque.controller;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String loginPage() {
    	return "login"; 
	}

	@PostMapping("/login")
	public String login(@RequestParam String nif,
						@RequestParam String senha,
						HttpSession session,
						Model model) {
		boolean credenciaisOk = false;

		if (!credenciaisOk) {
			model.addAttribute("erro", "NIF ou senha inválidos.");
			return "auth/login";
		}

		// Sessão Simples
		session.setAttribute("usuarioLogado", true);
		session.setAttribute("nif", nif);

		return "redirect:/app";
	}

	@GetMapping("/cadastro")
	public String cadastroPage() {
		return "auth/cadastro"; 
	}

	@PostMapping("/cadastro")
	public String cadastro(@RequestParam String nome,
						  @RequestParam String nif,
						  @RequestParam String senha,
						  Model model) {
		// TODO: validar se (nif,nome) está autorizado na tabela funcionarios_autenticados
		// TODO: salvar funcionario com senha (ideal: hash)
		model.addAttribute("erro", "Implementar cadastro no Service.");
		return "auth/cadastro";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
