package br.com.ZeToin.Utils;
import java.util.ArrayList;


import br.com.ZeToin.main.Ginasio;
import br.com.ZeToin.main.Jogador;
import br.com.ZeToin.main.Pokemon;
import br.com.ZeToin.main.SistemaPokemon;
/**
 * 
 * @author deyvid
 *
 */
public class Utils {
// ---------------- Criação ----------------------------
	/**
	 * Cria um novo jogador
	 * @param sistema Esse parametro é o sistema que armazena todos os jogadores, ginasios e pokemons.
	 */
	public static void criarJogador(SistemaPokemon sistema) {
		Jogador jogador = new Jogador(View.exibirInput("Jogador", "Digite o nome do novo jogador: "));
		// ----- TESTE -----
		jogador.setGinasios(sistema.todosGinasios);
		// ----- TESTE -----
		sistema.todosJogadores.add(jogador);
	}
	/**
	 * Cria um novo ginásio
	 * @param sistema Esse parametro é o sistema que armazena todos os jogadores, ginasios e pokemons.
	 */
	public static void criarGinasio(SistemaPokemon sistema) {
		Ginasio ginasio = new Ginasio(View.exibirInput("Ginásio", "Digite o nome do novo Ginasio: "));
		sistema.todosGinasios.add(ginasio);
	}
	/**
	 * Cria um novo pokemón
	 * @param sistema Esse parametro é o sistema que armazena todos os jogadores, ginasios e pokemons.
	 */
	public static void criarPokemon(SistemaPokemon sistema) {
		Pokemon pokemon = new Pokemon(View.exibirInput("Pokemón", "Digite o nome do novo Pokemón: "));
		sistema.todosPokemons.add(pokemon);
	}
// ---------------- Criação ----------------------------
	
// ---------------- Listagem ---------------------------
	public static Jogador selecionarJogador (SistemaPokemon sistema) {
		int opcao = 0;
		boolean deuBom = false;
		do {
			try {
				opcao = View.exibirInput("Jogadores", armazenarNomeJogadores(sistema), opcao);
				deuBom = true;
				if ((opcao - 1) >= sistema.todosJogadores.size() || (opcao - 1) < 0) {
					throw new IndexOutOfBoundsException("Insira um número presente na lista!");
				}
			} catch (IndexOutOfBoundsException e) {
				View.exibirMensagemErro("ERRO", e.getMessage());
				deuBom = false;
			} catch(NumberFormatException e) {
				View.exibirMensagemErro("ERRO", "Apenas números são permitidos!");
				deuBom = false;
			}
		}while(!deuBom);
		opcao--;
		return sistema.todosJogadores.get(opcao);
		
	}
	
	public static void listarTodosGinasios(SistemaPokemon sistema) {
		String nomeGinasios = "";
		int i = 0;
		for (i = 0; i< sistema.todosGinasios.size(); i++) {
			nomeGinasios += (i+1) + " - " + sistema.todosGinasios.get(i).getNome() + ", Dono: " + sistema.todosGinasios.get(i).getDono() + "\n";
		}
		View.exibirMensagemScrolavel("Ginásios", nomeGinasios);
	}
	
	public static void listarGinasiosDoJogador(Jogador jogador) {
		String nomeGinasios = "";
		int i = 0;
		for (i = 0; i< jogador.getGinasios().size(); i++) {
			nomeGinasios += (i+1) + " - " + jogador.getGinasios().get(i).getNome() + "\n";
		}
		View.exibirMensagemScrolavel("Ginásios", nomeGinasios);
	}
	
	public static void listarPokemonsQueExistem(SistemaPokemon sistema) {
		String nomePokemons = "";
		int i = 0;
		for (i = 0; i< sistema.todosPokemons.size(); i++) {
			nomePokemons += (i+1) + " - " + sistema.todosPokemons.get(i).getNome() + ", Tipo: " + sistema.todosPokemons.get(i).getTipo() + "\n";
		}
		View.exibirMensagemScrolavel("Pokémons", nomePokemons);
	}
	
	public static void listarPokemonsDoJogador(Jogador jogador) {
		String pokemons = "";
		for (Pokemon p : jogador.getPokemons()) {
			pokemons += "--- Pokémon " + (jogador.getPokemons().indexOf(p)+1) + " ---\n" + p.toString() + "\n";
		}
		View.exibirMensagemScrolavel("Pokémons", pokemons);
	}
// ---------------- Listagem ---------------------------
	
	public static String armazenarNomeJogadores(SistemaPokemon sistema) {
		String nomeJogadores = "";
		int i = 0;
		for (i = 0; i< sistema.todosJogadores.size(); i++) {
			nomeJogadores += (i+1) + " - " + sistema.todosJogadores.get(i).getNome() + "\n";
		}
		return nomeJogadores;
	}
	
	
	
}
