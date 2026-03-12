package br.senai.estoque.gerenciamento_estoque.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/app")
	public String appHome(HttpSession session, Model model) {
		Object usuarioLogado = session.getAttribute("usuarioLogado");
		if (usuarioLogado == null || !(Boolean) usuarioLogado) {
			return "redirect:/login";
		}

		model.addAttribute("nif", session.getAttribute("nif"));
		return "app/index"; // templates/app/index.html
	}

	@GetMapping("/app/categorias")
    public String categoriasPage() { return "app/categorias"; }

    @GetMapping("/app/materiais")
    public String materiaisPage() { return "app/materiais"; }

    @GetMapping("/app/ativos")
    public String ativosPage() { return "app/ativos"; }

    @GetMapping("/app/movimentacoes")
    public String movimentacoesPage() { return "app/movimentacoes"; }
}
