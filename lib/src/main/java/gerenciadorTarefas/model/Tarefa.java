package gerenciadorTarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import gerenciadorTarefas.ui.style.Style;

public class Tarefa {
	
	private boolean concluida;
	private String prazo, objetivo;
	
	public Tarefa(int dias, String objetivo) {
		this.concluida = false;
		this.prazo = formatarPrazo(dias);
		this.objetivo = objetivo;
	}
	
	private String formatarPrazo(int dias) {
		
		LocalDate dataHoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate prazo = dataHoje.plusDays(dias);
		
		return prazo.format(formatador);
		
	}
	
	public void mostrar() {
		String status = (isConcluida()) ? "Concluida ✔️" : "Pendente ❌";
		
		System.out.println(getObjetivo() + " | Prazo: "+ getPrazo()+ " | "+status);
	}
	
	public void concluir() {
		Style.escrever("Tarefa: "+objetivo+ " concluída com sucesso!");
		setConcluida(true);
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public String getPrazo() {
		return prazo;
	}

	public String getObjetivo() {
		return objetivo;
	}

}
