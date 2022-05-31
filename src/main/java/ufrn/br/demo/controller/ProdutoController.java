package ufrn.br.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.demo.model.Produto;
import ufrn.br.demo.service.ProdutoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.*;
import java.util.List;

@Controller
public class ProdutoController {
    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/produtos"})
    public String getHome(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("produtos", "prod");

        List<Produto> produtos = service.findAll();
        System.out.println(produtos);
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
    public String doSalvar(@ModelAttribute @Valid Produto p, Errors errors){

        if(errors.hasErrors()){
            return "cadastrar";
        }else{
            service.create(p);
            return "redirect:/";
        }
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