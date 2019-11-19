package br.com.ZeToin.main;

import java.util.ArrayList;
import java.util.Random;

import br.com.ZeToin.Utils.Utils;
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
			Utils.capturar(pokemonCapturado, this);
			this.pokemons.add(pokemonCapturado);
			View.exibirMensagem("Capturar Pokémon", "---- Pokemon ----" + "\n" + pokemonCapturado.toString() + "\n-----------------\nCapturado com sucesso!!!");
		} else {
			View.exibirMensagemErro("Capturar Pokémon", "O Pokémon " + randomPokemon.getNome() + " fugiu e não foi capturado!!");
		}
	}
	
	public void duelar(ArrayList<Ginasio> ginasios) {
		if(pokemons.size() < 3) {
			View.exibirMensagemErro("ERRO", "Você não possui o número necessário de pokémons para duelar!!");
			return;
		}
		
		String msgGinasios = "--- Ginásios ---\n";
		
		for(Ginasio g: ginasios) {
			if(g.getDono() != this) {
				msgGinasios += (ginasios.indexOf(g)+1) + " - " + g.getNome() + "\n"; 
			}
		}
		
		msgGinasios += "---------------\n";
		
		int index = View.exibirInput("Duelo", msgGinasios + " Digite o ginásio que deseja duelar: \n"
				+ "Digite -1 para voltar!", 0)-1;
		
		if(index+1 > ginasios.size() || index < 0) {
			if(index == -1) {
				return;
			}
			View.exibirMensagemErro("ERRO!", "Ginásio Inexistente!");
		} else {
			Ginasio gDuelo = ginasios.get(index);
			if(gDuelo.getDono() == null) {
				this.ginasios.add(gDuelo);
				gDuelo.setDono(this);
				for (Pokemon p : pokemons) {
					p.setExp(p.getExp() + 35);
				}
				View.exibirMensagem("Duelo", "Você dominou o ginásio que não tinha ninguém!");
			} else {
				
				Jogador defensor = gDuelo.getDono();
				int niveisDefensor = 0;
				int niveisAtacante = 0;
				
				int qtdVitoriasDef = 0;
				int qtdVitoriasAtac = 0;
				
				for(Pokemon pokDef: defensor.pokemons) {
					niveisDefensor += pokDef.getNivel();
				}
				
				for(Pokemon pokAtac: this.pokemons) {
					niveisAtacante += pokAtac.getNivel();
				}
				
				if(niveisAtacante > niveisDefensor+3) {
					View.exibirMensagem("Duelo", "Você venceu o duelo! Derrotou o jogador " + defensor.nome);
					gDuelo.setDono(this);
					for (Pokemon p : pokemons) {
						p.setExp(p.getExp() + 35);
					}
					for(Pokemon pDef: defensor.pokemons) {
						pDef.setExp(pDef.getExp() + 10);
					}
				} else if(niveisDefensor > niveisAtacante+3) {
					View.exibirMensagem("Duelo", "Você perdeu o duelo, para o jogador " + defensor.nome);
					for (Pokemon p : pokemons) {
						p.setExp(p.getExp() + 10);
					}
					for(Pokemon pDef: defensor.pokemons) {
						pDef.setExp(pDef.getExp() + 35);
					}
				} else {
					for(int i = 0; i < pokemons.size(); i++) {
						Pokemon pAtk = this.pokemons.get(i);
						Pokemon pDef = defensor.pokemons.get(i);
						
						View.exibirMensagem("Duelo", pAtk.nome + " X " + pDef.nome);
						
						if(pAtk.getTipo() == pDef.getTipo()) {
							View.exibirMensagem("Duelo", "Empatou...");
							continue;
						} else if(pAtk.getTipo() == TipoPokemon.Agua) {
							View.exibirMensagem("Duelo", "O atacante venceu!");
							qtdVitoriasAtac+=1;
						} else if(pAtk.getTipo() == TipoPokemon.Fogo && pDef.getTipo() == TipoPokemon.Vento) {
							View.exibirMensagem("Duelo", "O atacante venceu!");
							qtdVitoriasAtac+=1;
						} else {
							View.exibirMensagem("Duelo", "O atacante perdeu!");
							qtdVitoriasDef+=1;
						}
					}
					
					if(qtdVitoriasAtac == qtdVitoriasDef) {
						Random r = new Random();
						
						int valor = r.nextInt(101);
						
						if(valor > 50) {
							View.exibirMensagem("Duelo", "Você venceu o duelo! Derrotou o jogador " + defensor.nome);
							gDuelo.setDono(this);
							this.ginasios.add(gDuelo);
							defensor.ginasios.remove(gDuelo);
							for (Pokemon p : pokemons) {
								p.setExp(p.getExp() + 35);
							}
							for(Pokemon pDef: defensor.pokemons) {
								pDef.setExp(pDef.getExp() + 10);
							}
						} else {
							View.exibirMensagem("Duelo", "Você perdeu o duelo, para o jogador " + defensor.nome);
							for (Pokemon p : pokemons) {
								p.setExp(p.getExp() + 10);
							}
							for(Pokemon pDef: defensor.pokemons) {
								pDef.setExp(pDef.getExp() + 35);
							}
						}
					} else if(qtdVitoriasAtac > qtdVitoriasDef) {
						View.exibirMensagem("Duelo", "Você venceu o duelo! Derrotou o jogador " + defensor.nome);
						gDuelo.setDono(this);
						this.ginasios.add(gDuelo);
						defensor.ginasios.remove(gDuelo);
						for (Pokemon p : pokemons) {
							p.setExp(p.getExp() + 35);
						}
						for(Pokemon pDef: defensor.pokemons) {
							pDef.setExp(pDef.getExp() + 10);
						}
					} else {
						View.exibirMensagem("Duelo", "Você perdeu o duelo, para o jogador " + defensor.nome);
						for (Pokemon p : pokemons) {
							p.setExp(p.getExp() + 10);
						}
						for(Pokemon pDef: defensor.pokemons) {
							pDef.setExp(pDef.getExp() + 35);
						}
					}
				}
				
				
				
				
				
			}
		}
		
	}
	
	public void removerPokemon() {
		if(pokemons.isEmpty()) {
			View.exibirMensagemErro("ERRO", "Este jogador não possui pokémons para remover!");
			return;
		}
		String textoPokemons = "";
		for (Pokemon p: pokemons) {
			textoPokemons += "--- Pokémon " + (pokemons.indexOf(p)+1) + " ---\n" + p.toString() + "\n";
		}
		
		int index = View.exibirInputScrolavel("Remover pokemon", textoPokemons + "\n Digite o número do pokemon que deseja remover: ")-1;
		
		if(index+1 > pokemons.size() || index < 0) {
			View.exibirMensagemErro("ERRO", "Pokémon inexistente!");
		} else {
			Pokemon pokemonARemover = pokemons.get(index);
			pokemons.remove(pokemonARemover);
			View.exibirMensagem("Remover Pokémon", "--- Pokémon --- \n" + pokemonARemover.toString() + "\n---------------\nRemovido com sucesso!!");
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
