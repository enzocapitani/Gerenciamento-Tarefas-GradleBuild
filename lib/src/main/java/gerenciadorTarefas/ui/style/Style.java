package gerenciadorTarefas.ui.style;

public class Style implements StyleInterface {
	
	private static int delay = 70;
	
	public static void escrever(String frase, int delay) {
		for(int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			
			//Impede que imprima letras vazias, escreve mais rapido
			if(letra == ' ') { System.out.print(" "); continue;}
			
			System.out.print(letra);
			
			try {
				Thread.sleep(delay);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println();
	}
	
	public static void escrever(String frase) {
		for(int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			
			//Impede que imprima letras vazias, escreve mais rapido
			if(letra == ' ') { 
				System.out.print(" ");
				continue;
			}else {
				System.out.print(letra);				
			}
			
			try {
				Thread.sleep(delay);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println();
	}
	
}
