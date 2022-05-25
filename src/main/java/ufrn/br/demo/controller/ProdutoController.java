package ufrn.br.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ufrn.br.demo.model.Produto;
import ufrn.br.demo.service.ProdutoService;

/*@Controller é responsável tanto por receber requisições como por enviar a resposta ao usuário,
e responsabiliza por informar a View, os atributos que serão visíveis para a mesma e também por receber parâmetros vindos da View. 
E, por último, responder ao usuário o que foi requisitado. */
@Controller
public class ProdutoController {
    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    @RequestMapping(value = {"/", "/produtos"})
    public String getHome(Model model){

        List<Produto> produtos = service.findAll();
        model.addAttribute("produtosList", produtos);

        return "index";
    }

    @RequestMapping("/cadastrar")
    public String getCadastar(Model model){
        Produto p = new Produto();
        model.addAttribute("produto", p);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute Produto p){
        service.create(p);
        return "redirect:/";
    }

    @RequestMapping("/deletar/{id}")
    public String doDeletar(@PathVariable (name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public String doEditar(@PathVariable (name = "id") Long id, Model model){

        Produto p = service.findById(id);
        model.addAttribute("produto", p);
        return "cadastrar";
    }
}