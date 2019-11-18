package br.com.ZeToin.Utils;

import javax.swing.JOptionPane;
/**
 * 
 * @author deyvid
 *
 */
public class View {
	/**
	 * Exibe uma mensagem para o usuário.
	 * @param title	Título da mensagem.
	 * @param msg	Mensagem para o usuário
	 */
	public static void exibirMensagem(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);
	}
	/**
	 * Vai armazenar a entrada de dados que deverá ser uma cadeia de caracteres inserida pelo usuário
	 * @param title	Título da mensagem
	 * @param msg	Mensagem para informar o que o usuário deverá digitar
	 * @return	Valor inserido pelo usuário.
	 */
	public static String exibirInput(String title, String msg) {
		return JOptionPane.showInputDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);	
	}
	
	/**
	 * Vai armazenar a entrada de dados que deverá ser um valor inteiro inserida pelo usuário
	 * @param title	Título da mensagem
	 * @param msg	Mensagem para informar o que o usuário deverá digitar
	 * @return	Valor inserido pelo usuário.
	 */
	public static Integer exibirInput(String title, String msg, Integer valor) {
		valor = Integer.parseInt(JOptionPane.showInputDialog(null, msg, title, JOptionPane.DEFAULT_OPTION));
		return valor;
	}
	/**
	 * Vai armazenar a entrada de dados que deverá ser um valor Double inserida pelo usuário
	 * @param title	Título da mensagem
	 * @param msg	Mensagem para informar o que o usuário deverá digitar
	 * @return	Valor inserido pelo usuário.
	 */
	public static Double exibirInput(String title, String msg, Double valor) {
		valor = Double.parseDouble(JOptionPane.showInputDialog(null, msg, title, JOptionPane.DEFAULT_OPTION));
		return valor;
	}
	
}
