package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    // LISTA: mostra todos os livros cadastrados
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livros/inicio";
    }

    // CADASTRO: abre o formulário vazio
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    // CADASTRO: salva o livro e volta para a lista
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {
        repository.save(livro);
        return "redirect:/livros";
    }

    // EXCLUIR pelo id
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/livros";
    }
}