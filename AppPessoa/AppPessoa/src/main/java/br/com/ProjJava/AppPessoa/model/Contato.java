package br.com.ProjJava.AppPessoa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false) //not null
	private TipoContato tipoContato;
	
	@Column(nullable = false) //not null
	private String contato;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	public Contato() {}
	
	public Contato(Long id, TipoContato tipoContato, String contato, Pessoa pessoa)
	{
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public TipoContato getTipoContato() 
	{
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) 
	{
		this.tipoContato = tipoContato;
	}

	public String getContato() 
	{
		return contato;
	}

	public void setContato(String contato) 
	{
		this.contato = contato;
	}

	public Pessoa getPessoa() 
	{
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	}
	
	public enum TipoContato 
	{
		
		TELEFONE(0),
		CELULAR(1),
		EMAIL(2),
		REDE_SOCIAL(3);

		
		private int tipoContato;
		
		TipoContato(int tipo) 
		{
			this.tipoContato = tipo;
		}

		public int getTipo() 
		{
			return tipoContato;
		}	
	}
	
	@Override //sobrescrever
	public String toString() 
	{
		String retorno = "[ " 				 + 
						 "Id: " 			 + this.id 			+ ", " +
						 "Tipo de contato: " + this.tipoContato + ", " +
						 "Contato: " 		 + this.contato 	+ ", " +
						 "pessoa: " 		 + this.pessoa 		+ "]";
		return retorno;
	}
}
