package br.com.ZeToin.main;

import java.util.ArrayList;
import java.util.Random;

import br.com.ZeToin.Utils.View;

public class Jogador extends Personagem{
	
	//Atributos
	private ArrayList<Ginasio> ginasios = new ArrayList<Ginasio>();
	private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	//Construtores
	public Jogador(String nome) {
		super(nome);
	}
	
	//Métodos
	public void capturarPokemon(ArrayList<Pokemon> pokemons) {
		if(this.pokemons.size() == 3) {
			View.exibirMensagemErro("Capturar Pokémon", "Limite de pokemons atingido!! \nVocê deve remover um pokémon primeiro para capturar outro!");
			return;
		}
		Random r = new Random();
		int qtdPokemons = pokemons.size();
		 
		Pokemon randomPokemon = pokemons.get(r.nextInt(qtdPokemons));
		int taxaAcerto = r.nextInt(101);
		
		if(taxaAcerto > 60) {
			Pokemon pokemonCapturado = new Pokemon(randomPokemon.getNome(), randomPokemon.getTipo());
			pokemonCapturado.capturar(this);
			this.pokemons.add(pokemonCapturado);
			View.exibirMensagem("Capturar Pokémon", "---- Pokemon ----" + "\n" + pokemonCapturado.toString() + "\n Capturado com sucesso!!!");
		} else {
			View.exibirMensagemErro("Capturar Pokémon", "O Pokémon " + randomPokemon.getNome() + " fugiu e não foi capturado!!");
		}
	}
	
	public void removerPokemon() {
		String textoPokemons = "";
		for (Pokemon p: pokemons) {
			textoPokemons += "--- Pokémon " + (pokemons.indexOf(p)+1) + " ---\n" + p.toString() + "\n";
		}
		
		int index = View.exibirInputScrolavel("Remover pokemon", textoPokemons + "\n Digite o número do pokemon que deseja remover: ");
		
		if(index+1 >= pokemons.size()) {
			View.exibirMensagemErro("ERRO", "Pokémon inexistente!");
		} else {
			Pokemon pokemonARemover = pokemons.get(index);
			pokemons.remove(pokemonARemover);
		}
		
	}
	
	//Getters e Setters
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

	@Override
	public String toString() {
		return "" + nome;
	}
	
	
	
	
}
