package br.com.ZeToin.main;
/**
 * 
 * @author deyvid
 *
 */
public interface PodeSerCapturado {
	/**
	 * Interface que é implementada por classes que podem possuir um dono do tipo Jogador (Pokemon e Ginasio).
	 * @param jogador Esse parâmetro define o dono da instancia que chama esse método.
	 */
	public void capturar (Jogador jogador);
}
