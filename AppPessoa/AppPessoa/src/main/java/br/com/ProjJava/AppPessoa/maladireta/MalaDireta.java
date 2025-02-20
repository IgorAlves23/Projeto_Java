package br.com.ProjJava.AppPessoa.maladireta;

import br.com.ProjJava.AppPessoa.model.Pessoa;

public record MalaDireta(Long id, String nome, String enderecoCompleto) 
{
	public static MalaDireta from(Pessoa pessoa)
	{
	String enderecoCompleto = 
				pessoa.getEndereco() + ", " 
			  + pessoa.getCep()    	 + ", " 
			  + pessoa.getCidade() 	 + "/" 
			  + pessoa.getUf();
	
	return new MalaDireta(pessoa.getId(), pessoa.getNome(), enderecoCompleto);
	}
}
