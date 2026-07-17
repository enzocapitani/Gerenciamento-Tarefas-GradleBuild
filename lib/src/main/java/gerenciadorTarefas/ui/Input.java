package gerenciadorTarefas.ui;

import java.util.Scanner;

import gerenciadorTarefas.ui.style.Style;

public class Input {
	static Scanner scr = new Scanner(System.in);
	
	public static int pegaInt() {
		System.out.print("Resposta: ");
		
		int resposta = scr.nextInt();
		scr.nextLine();
		
		System.out.println(Style.separador);
		
		return resposta;
	}
	
	public static String pegaString() {
		System.out.print("Resposta: ");
		
		String resposta = scr.nextLine();
		System.out.println(Style.separador);
		
		return resposta;
	}
	
}
