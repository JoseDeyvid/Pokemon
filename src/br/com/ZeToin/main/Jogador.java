package br.com.ZeToin.main;

import java.util.ArrayList;

public class Jogador extends Personagem{
	private ArrayList<Ginasio> ginasios = new ArrayList<Ginasio>();
	private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	public Jogador(String nome) {
		super(nome);
	}
	
	
	public ArrayList<Ginasio> getGinasios() {
		return ginasios;
	}
	public void setGinasios(ArrayList<Ginasio> ginasios) {
		this.ginasios = ginasios;
	}
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	
}
