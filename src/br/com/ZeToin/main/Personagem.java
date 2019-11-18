package br.com.ZeToin.main;

public abstract class Personagem {
	private String nome;

	public Personagem(String nome) {
		super();
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
