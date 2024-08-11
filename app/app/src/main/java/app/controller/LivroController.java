package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping("/salvarLivro")
	public ResponseEntity<String>salvarLivro(@RequestBody Livro livro){
		
		try {
			
			String resposta = this.livroService.salvarLivro(livro);
			
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu ruim", HttpStatus.BAD_REQUEST);	
		
	}
	
}
	@GetMapping("/buscaLivro/{id}")
	public ResponseEntity<Livro>buscarIdLivro(@PathVariable long id){
		
		try {
			
			Livro livro = this.livroService.buscarId(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String>atualizaLivro(@RequestBody Livro livro,@PathVariable long id) {
		try {
			
			String resposta = this.livroService.atualizaLivro(livro, id);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("erro ao deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarLivro(@PathVariable long id) {
		
		try {
			
			String resposta = this.livroService.deletarLivro(id);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("erro ao deletar", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@GetMapping("/showAll")
	public ResponseEntity<List<Livro>>mostrarTudo(){
		
		try {
			
			List<Livro> lista = this.livroService.mostrarTudo();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
	
}