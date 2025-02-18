package br.com.ProjJava.AppPessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ProjJava.AppPessoa.model.Pessoa;
import br.com.ProjJava.AppPessoa.repository.PessoaRepository;

public class PessoaService 
{
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//CRUD = Create
	public Pessoa save(Pessoa pessoa)
	{
		//verifica se o campo nome está preenchido
		if(pessoa.getNome() == null)
		{
			System.out.println("Nome da pesssoa vazio");
			return null;
		}
		try 
		{
			//vai para o banco de dados
			return pessoaRepository.save(pessoa);
		} 
		catch (Exception e) 
		{
			System.out.println("Erro ao inserir pessoa: " + 
								pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}
	
	//CRUD - Read (leitura individual ou lista
	public Optional<Pessoa> findById(Long id)
	{
		return pessoaRepository.findById(id);
	}
	
	public List<Pessoa> findAll()
	{
		return pessoaRepository.findAll();
	}
	
	//CRUD - Update
	public Pessoa update(Pessoa pessoa)
	{
		//verifica se a pessoa existe
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		//se existir, atualizar:
		if(findPessoa.isPresent())
		{
			Pessoa updPessoa = findPessoa.get(); //setId
			updPessoa.setNome(pessoa.getNome()); //veio por parametro
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa); //Update
		}
		return pessoaRepository.save(pessoa); //Insert
	}
	
	//CRUD - Delete
	public void delete(Long id)
	{
		pessoaRepository.deleteById(id);
	}
}
