package br.com.ProjJava.AppPessoa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	
	@Column(nullable = false) //not null
	private String nome;
	
	@Column
	private String endereco;
	
	@Column
	private String cep;
	
	@Column
	private String cidade;
	
	@Column
	private String uf;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Contato> contatos;

	public Pessoa() {}

	public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf)
	{
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) 
	{
		this.cep = cep;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}

	public String getUf() 
	{
		return uf;
	}

	public void setUf(String uf) 
	{
		this.uf = uf;
	}
	
	@Override //sobrescrever
	public String toString() 
	{
		String retorno = "[ " 		  + 
						 "Id: " 	  + this.id 	  + ", " +
						 "Nome: "     + this.nome 	  + ", " +
						 "Endereço: " + this.endereco + ", " +
						 "CEP: " 	  + this.cep 	  + ", " +
						 "Cidade: "   + this.cidade   + ", " +
						 "UF: " 	  + this.uf  	  + "]";	
		return retorno;
	}
	
}


