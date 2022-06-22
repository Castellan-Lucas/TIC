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

		// vamos fazer o clássico do Spring
		// criar uma injeção de dependência
		@Autowired
		ProdutosRepository injecao;
		
		@GetMapping("/pokemon")
		@CrossOrigin(origins="*")
		public List<Produtos> get(){
			// select * from pokemon
			return injecao.findAll();
		}
		
		@PostMapping("/pokemon")
		@CrossOrigin(origins="*")
		public Produtos save(@RequestBody Produtos produtos) {
			// insert into pokemon values ...
			Produtos novo = injecao.save(produtos);
			return novo;
			
		}
		
		@DeleteMapping("/pokemon/{id}")
		@CrossOrigin(origins="*")
		public String delete(@PathVariable Long id) {
			try {
				injecao.deleteById(id);
				return "Remoção realizada com sucesso";
			}
			catch(Exception e) {
				return "Nenhum pokemon encontrado";
			}	
		}
		
		@PutMapping("/pokemon")
		@CrossOrigin(origins="*")
		public Produtos update(@RequestBody Produtos pokemon) {
			Produtos novo = injecao.save(pokemon);
			return novo;
		}
	}
