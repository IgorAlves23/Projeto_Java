package br.com.ProjJava.AppPessoa.resource;

import java.util.List;
import java.util.Optional;

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

import br.com.ProjJava.AppPessoa.maladireta.MalaDireta;
import br.com.ProjJava.AppPessoa.model.Pessoa;
import br.com.ProjJava.AppPessoa.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoa") //http://localhost:8080/api/pessoa
public class PessoaResource 
{
	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Cria uma nova pessoa")
	@PostMapping //POST //http://localhost:8080/api/pessoa
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa)
	{
		Pessoa newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) 
		{
			return ResponseEntity.badRequest().build(); //400
		}
		else
		{
			return ResponseEntity.ok(newPessoa); //200 e retorna pessoa
		}
	}
	
	@Operation(summary = "Retorna os dados de uma pessoa por ID")
	@GetMapping("/{id}") //GET //http://localhost:8080/api/pessoa/1
	//retorna os dados de uma Pessoa por ID
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id)
	{
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		
		if(pessoa.isEmpty()) 
		{
			return ResponseEntity.notFound().build(); //404
		}
		else
		{
			return ResponseEntity.ok(pessoa); //200
		}
	}
	
	@Operation(summary = "Retorna os dados de uma pessoa por ID para mala direta")
	@GetMapping("/maladireta/{id}") //GET //http://localhost:8080/api/pessoa/maladireta/1
	//retorna os dados de uma Pessoa por ID para mala direta
	public ResponseEntity<MalaDireta> findPessoaPorId(@PathVariable Long id)
	{
		try 
		{
			MalaDireta malaDireta = pessoaService.findPessoaPorId(id);
	        return ResponseEntity.ok(malaDireta);
		} catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@Operation(summary = "Retorna uma lista de todas as pessoas cadastradas")
	@GetMapping //GET //http://localhost:8080/api/pessoa
	public ResponseEntity<List<Pessoa>> findAll()
	{
		List<Pessoa> pessoa = pessoaService.findAll();
		if(pessoa == null) 
			return ResponseEntity.badRequest().build(); //400
		if(pessoa.size() == 0)
			return ResponseEntity.notFound().build(); //404
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Atualiza uma pessoa existente por ID")
	@PutMapping("/{id}") //PUT //http://localhost:8080/api/pessoa
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa)
	{
		Pessoa updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null) 
		{
			return ResponseEntity.badRequest().build(); //400
		}
		else 
		{
			return ResponseEntity.ok(updPessoa); //200
		}
	}
	
	@Operation(summary = "Deleta uma pessoa existente por ID")
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/pessoa/1
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
