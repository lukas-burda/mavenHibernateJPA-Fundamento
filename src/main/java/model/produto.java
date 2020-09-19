package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_bar")
	private long  cod_bar;
	
	@Column(name = "cod_interno")
	private int cod_interno;
	
	@Column(name = "nome")
	private String nome;
	
	public produto() {
		
	}
	
	public produto(String nome, int cod_interno) {
		super();
		this.nome = nome;
		this.cod_interno = cod_interno;
		
	}

	public long getCod_bar() {
		return cod_bar;
	}

	public void setCod_bar(long cod_bar) {
		this.cod_bar = cod_bar;
	}

	public long getCod_interno() {
		return cod_interno;
	}

	public void setCod_interno(int cod_interno) {
		this.cod_interno = cod_interno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
