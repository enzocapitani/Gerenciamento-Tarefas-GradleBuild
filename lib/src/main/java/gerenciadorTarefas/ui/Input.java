package gerenciadorTarefas.ui;

import java.util.Scanner;

public class Input {
	static Scanner scr = new Scanner(System.in);
	static int pegaInt() {
		System.out.print("Resposta: ");
		return scr.nextInt();
	}
}
