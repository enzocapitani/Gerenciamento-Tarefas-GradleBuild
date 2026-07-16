package gerenciadorTarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.math3.exception.NullArgumentException;

import gerenciadorTarefas.model.Tarefa;
import gerenciadorTarefas.repository.InMemoryTaskRepository;
import gerenciadorTarefas.ui.style.Style;

public class TaskService {
	
	InMemoryTaskRepository taskrepo;
	Scanner scr;
	
	public TaskService(InMemoryTaskRepository taskrepo) {
		this.taskrepo = taskrepo;
		scr = new Scanner(System.in);
	}
	
	public void concluirTarefa(int index) {
		if(index >= taskrepo.getTarefas().size() || index < 0) {
			Style.escrever("ERRO! Indice de tarefa inválido!", 10);
			return;
		}
		
		taskrepo.concluir(index);
		
	}
	
	public boolean adicionarTarefa(String tarefa, int prazo) {
		String tarefaFinal = tarefa;
		int prazoFinal = prazo;
		
		//Captura valores invalidos - erros
		if(tarefa == null) {
			Style.escrever("Erro! tarefa enviou valor nulo");
			return true;
		}
		
		if(prazoFinal < 0) {
			Style.escrever("Erro! Prazo inválido");
			return true;
		}
		
		if(tarefaFinal.trim().length() < 4 || tarefaFinal.isBlank() || tarefaFinal.isEmpty()) {
			Style.escrever("Erro! Tarefa menor que 3 letras ou vazia");
			return true;
		}
		
		taskrepo.adcionarTarefa(new Tarefa(prazo, tarefa));
		return false;
		
	}
	
	public void concluirTarefa(Tarefa tarefa) {
		if(!taskrepo.getTarefas().contains(tarefa)){
			Style.escrever("Erro! Tarefa inexistente");
			return;
		}
		
		taskrepo.concluir(taskrepo.getTarefas().indexOf(tarefa));
		
	}
	
	public void limparConcluidas() {
		if(!confirmacao()) return;
		
		taskrepo.limparConcluidas();
		
	}
	
	public ArrayList<Tarefa> enviarCopia() {
		return new ArrayList<>(taskrepo.getTarefas());
	}
	
	private boolean confirmacao() {
		while(true) {
			Style.escrever("Confirma? S/N");
			
			if(scr.nextLine().equalsIgnoreCase("s")) return true;
			if(scr.nextLine().equalsIgnoreCase("n")) return false;
			
			Style.escrever("Resposta inválida!");
		}
	}
	
}
