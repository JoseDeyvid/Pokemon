package br.com.ZeToin.main;

import br.com.ZeToin.Utils.View;

public class Pokemon extends Personagem implements Capturavel{

	//Atributos
	private String tipo = "";
	private int nivel = 0;
	private int exp = 0;
	private Jogador dono = null;
	
	//Construtores
	public Pokemon(String nome) {
		super(nome);
		this.tipo = selecionarTipo();
		this.nivel = 1;
		this.exp = 0;
		this.dono = null;
	}
	
	public Pokemon(String nome, String tipo) {
		super(nome);
		this.tipo = tipo;
		this.nivel = 1;
		this.exp = 0;
		this.dono = null;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "Nome: " + nome + "\n"
				+ "Tipo: " + tipo + "\n"
				+ "Nível: " + nivel + "\n"
				+ "Exp: " + exp;
	}
	
	@Override
	public void capturar(Jogador jogador) {
		// TODO Auto-generated method stub
		this.dono = jogador;
	}
	
	/**
	 * Seleciona o tipo do pokemon no momento em que ele é criado
	 * @return Retorna o tipo do pokemon de acordo com o escolhido pelo usuário.
	 */
	private String selecionarTipo() {
		int opcao = 0;
		View.exibirInput("Selecione o tipo do pokemon: ", "1 - Água\n"
				+ "2 - Fogo\n"
				+ "3 - Vento\n", opcao);
		if (opcao == 1) {
			return "Água";
		} else if (opcao == 2) {
			return "Fogo";
		} else {
			return "Vento";
		}
	}

	//Getters e Setters
	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public Jogador getDono() {
		return dono;
	}


	public void setDono(Jogador dono) {
		this.dono = dono;
	}


	public String getTipo() {
		return tipo;
	}

}
