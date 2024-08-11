package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {
	 
	@Autowired
	private LivroRepository livroRepository;

	public String salvarLivro(Livro livro) {
		
		this.livroRepository.save(livro);
		
		return "salvou legal o livro";
	}
	
	public Livro buscarId(Long id) {
		
		Optional<Livro> livro = this.livroRepository.findById(id);
		
		return livro.get();
				
	}
	
	public String atualizaLivro(Livro livro, Long id) {
		livro.setId(id);
		this.livroRepository.save(livro);
		
		return "Livro atualizado";
		
	}
	
	public String deletarLivro(long id) {
		this.livroRepository.deleteById(id);
		
		return "livro foi de arrasta";
	}
	
	public List<Livro> mostrarTudo() {
	    List<Livro> lista = this.livroRepository.findAll();
	    return lista;
	}
 
}
