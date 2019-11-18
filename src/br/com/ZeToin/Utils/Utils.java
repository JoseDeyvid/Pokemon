package br.com.ZeToin.Utils;
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
		opcao = View.exibirInput("Jogadores", armazenarNomeJogadores(sistema), opcao);
		opcao--;
		return sistema.todosJogadores.get(opcao);
		
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
