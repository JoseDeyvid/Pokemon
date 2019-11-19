package br.com.ZeToin.Utils;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	 * Exibe uma mensagem de erro para o usuário
	 * @param title Título da mensagem
	 * @param msg Mensagem de erro para o usuário
	 */
	public static void exibirMensagemErro(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Exibe uma mensagem scrolável para o usuário
	 * @param title Titulo da mensagem
	 * @param msg Mensagem para o usuário
	 */
	public static void exibirMensagemScrolavel(String title, String msg) {
		JTextArea textArea = new JTextArea(msg);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 250, 250 ) );
		JOptionPane.showMessageDialog(null, scrollPane, title,  
		                                       JOptionPane.DEFAULT_OPTION);
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
	
	public static Integer exibirInputScrolavel(String title, String msg) {
		JTextArea textArea = new JTextArea(msg);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 250, 250 ) );
		return Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, title, JOptionPane.DEFAULT_OPTION));
	}
	
}
