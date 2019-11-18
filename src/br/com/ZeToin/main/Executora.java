package br.com.ZeToin.main;

import br.com.ZeToin.Utils.Utils;
import br.com.ZeToin.Utils.View;
public class Executora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaPokemon sistemaPokemon = new SistemaPokemon();
		int i = 0;
		View.exibirMensagem("Iniciando", "É necessário, no mínimo: 2 jogadores, 1 ginásio e 3 pokémons.");
//		Utils.criarGinasio(sistemaPokemon);
		
		for (i = 1; i<= 2; i++) {
			Utils.criarJogador(sistemaPokemon);
		}
		
//		for (i = 1; i<= 3; i++) {
//			Utils.criarPokemon(sistemaPokemon);
//		}
		menuInicial(sistemaPokemon);
	}
	
	public static void menuInicial(SistemaPokemon sistema) {
		int opcao = 0;
		do {
			opcao = View.exibirInput("Menu Inicial","1 - Jogadores\n"
					+ "2 - Ginásios\n"
					+ "3 - Pokémons\n"
					+ "0 - Sair.", opcao);
			System.out.println(opcao);
			switch(opcao) {
			case 1:
				menuJogadores(sistema);
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				return;
			}
		} while(opcao != 0);
	}
	
	public static void menuJogadores(SistemaPokemon sistema) {
		int opcao = 0;
		do {
			opcao = View.exibirInput("Menu Jogadores","1 - Criar Jogador\n"
					+ "2 - Selecionar Jogador\n"
					+ "0 - Voltar.", opcao);
			switch(opcao) {
			case 1:
				Utils.criarJogador(sistema);
				break;
			case 2:
				menuJogador(Utils.selecionarJogador(sistema));
				break;
			case 0:
				return;
			}
		} while (opcao != 0);
	}
	
	public static void menuJogador (Jogador jogador) {
		int opcao = 0;
		do {
			opcao = View.exibirInput(jogador.getNome(),"1 - Listar Ginásios\n"
					+ "2 - Listar Pokémons\n"
					+ "3 - Duelar\n"
					+ "4 - Capturar Pokémon\n"
					+ "5 - Remover Pokémon\n"
					+ "0 - Voltar.", opcao);
			switch(opcao) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				return;
			}
		} while (opcao != 0);
	}
	

}
