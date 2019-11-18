package br.com.ZeToin.main;

public class Ginasio implements Capturavel{
	
	// --- Atributos ---
	
	private String nome;
	private Jogador dono = null;
	
	
	// --- Construtores ---
	
	public Ginasio(String nome) {
		super();
		this.nome = nome;
	}
	
	// --- Métodos ---
	
	@Override
	public void capturar(Jogador jogador) {
		// TODO Auto-generated method stub
		this.dono = jogador;
	}

	// --- Getters e Setters ---
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Jogador getDono() {
		return dono;
	}


	public void setDono(Jogador dono) {
		this.dono = dono;
	}

}
