package ufrn.br.demo.service;

import org.springframework.stereotype.Service;

import ufrn.br.demo.model.Produto;
import ufrn.br.demo.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

//O @Service serve para indicar que ele está mantendo a lógica de negócios.
@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto create(Produto p){
        return repository.save(p);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Produto update(Produto p){
        return repository.saveAndFlush(p);
    }

    public Produto findById(Long id){

        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isPresent()){
            return produtoOptional.get();
        }else{
            return null;
        }
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }
}