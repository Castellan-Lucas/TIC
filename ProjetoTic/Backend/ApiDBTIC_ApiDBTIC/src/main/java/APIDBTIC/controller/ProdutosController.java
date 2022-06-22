package APIDBTIC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import APIDBTIC.model.Produtos;
import APIDBTIC.model.repositories.ProdutosRepository;

@RestController
public class ProdutosController {

		@Autowired
		ProdutosRepository injecao;
		
		@GetMapping("/produtos")
		@CrossOrigin(origins="*")
		public List<Produtos> get(){
			
			return injecao.findAll();
		}
		
		@PostMapping("/produtos")
		@CrossOrigin(origins="*")
		public Produtos save(@RequestBody Produtos produtos) {
			
			Produtos novo = injecao.save(produtos);
			return novo;
			
		}
		
		@DeleteMapping("/produtos/{id}")
		@CrossOrigin(origins="*")
		public String delete(@PathVariable Long id) {
			try {
				injecao.deleteById(id);
				return "Remoção realizada com sucesso";
			}
			catch(Exception e) {
				return "Nenhum produto encontrado";
			}	
		}
		
		@PutMapping("/produtos")
		@CrossOrigin(origins="*")
		public Produtos update(@RequestBody Produtos produtos) {
			Produtos novo = injecao.save(produtos);
			return novo;
		}
	}
