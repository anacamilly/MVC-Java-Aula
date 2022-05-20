package ufrn.br.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("nome", "Hello que veio do código");
        return "index";
    }
}