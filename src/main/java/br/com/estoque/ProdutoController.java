package br.com.estoque;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {
    private final ProdutoRepositorio produtos;

    public ProdutoController(ProdutoRepositorio produtos) {
        this.produtos = produtos;
    }

    @ModelAttribute("categorias")
    public Categoria[] categorias() {
        return Categoria.values();
    }

    @GetMapping("/")
    public String formulario() {
        return "index";
    }

    @PostMapping("/")
    public String adicionar(@RequestParam(defaultValue = "") String titulo,
                            @RequestParam(defaultValue = "") String categoria,
                            @RequestParam(defaultValue = "") String quantidade,
                            Model model, RedirectAttributes redirect) {
        titulo = titulo.strip();
        model.addAttribute("titulo", titulo);
        model.addAttribute("categoria", categoria);
        model.addAttribute("quantidade", quantidade);

        if (titulo.isEmpty() || titulo.length() > 120) {
            model.addAttribute("erro", "Informe um título de até 120 caracteres.");
            return "index";
        }

        Categoria tipo;
        try {
            tipo = Categoria.valueOf(categoria);
        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", "Selecione uma categoria.");
            return "index";
        }

        int unidades;
        try {
            unidades = Integer.parseInt(quantidade);
        } catch (NumberFormatException e) {
            unidades = 0;
        }

        if (unidades < 1) {
            model.addAttribute("erro", "Informe uma quantidade inteira entre 1 e 2147483647.");
            return "index";
        }

        produtos.save(new Produto(titulo, tipo, unidades));
        redirect.addFlashAttribute("sucesso", titulo + " foi adicionado ao estoque.");
        return "redirect:/";
    }
}
