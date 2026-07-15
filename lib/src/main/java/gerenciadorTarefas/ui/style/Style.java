package gerenciadorTarefas.ui.Style;

public class Style implements StyleInterface {
	
	private static int delay = 70;
	
	public static void escrever(String frase, int delay) {
		for(int i = 0; i < frase.length(); i++) {
			System.out.print(frase.charAt(i));
			
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
			System.out.print(frase.charAt(i));
			
			try {
				Thread.sleep(delay);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println();
	}
	
}
