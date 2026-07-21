package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import ui.style.Style;

public class Input {
	static Scanner scr = new Scanner(System.in);
	
	public static int pegaInt() {
		System.out.print("Resposta: ");
		int resposta = 0;
		
		try{
			
			resposta = scr.nextInt();
			scr.nextLine();

		}catch(InputMismatchException e){

			System.out.println(Style.separador);
			System.err.println("Erro! Valor nao numérico");
			System.out.println(Style.separador);

			//Limpa o buffer, para impedir que fique em loop infinito
			scr.nextLine();

			return 0;
		}
		
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
