package com.exemplo.teste.api.resorce;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exemplo.teste.api.model.Pessoa;
import com.exemplo.teste.api.repository.PessoaRepository;
import com.exemplo.teste.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "https://cadastro-app.vercel.app/")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> list() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long id){
		return pessoaRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalvar = pessoaRepository.save(pessoa);
		pessoaSalvar.getDataCadastro();
		
		
	  URI uri =	ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
		.buildAndExpand(pessoaSalvar.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		
		return ResponseEntity.created(uri).body(pessoaSalvar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id,@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(id, pessoa);
		
		
		
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
		
		
	}
	
}
