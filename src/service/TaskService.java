package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Tarefa;
import repository.InMemoryTaskRepository;
import ui.Input;
import ui.style.Style;

public class TaskService {
	
	InMemoryTaskRepository taskrepo;
	Scanner scr;
	
	public TaskService(InMemoryTaskRepository taskrepo) {
		this.taskrepo = taskrepo;
		scr = new Scanner(System.in);
	}
	
	public void adicionarTarefa(String tarefa, int prazo) {
		String tarefaFinal = tarefa;
		int prazoFinal = prazo;
		
		//Captura valores invalidos - erros
		if(tarefa == null) {
			Style.escrever("Erro! tarefa enviou valor nulo");
			return;
		}
		
		if(prazoFinal < 0) {
			Style.escrever("Erro! Prazo inválido");
			return;
		}
		
		if(tarefaFinal.trim().length() < 4 || tarefaFinal.isBlank() || tarefaFinal.isEmpty()) {
			Style.escrever("Erro! Tarefa menor que 3 letras ou vazia");
			return;
		}
		
		Style.escrever("Você vai criar a tarefa: "+tarefaFinal+" com prazo de "+prazoFinal+" dias", 10);
		
		if(confirmacao()) {
			taskrepo.adcionarTarefa(new Tarefa(prazo, tarefa));
			Style.escrever("Tarefa criada com suceso!");
		}
		
	}
	
	public void concluirTarefa(int indice) {
		int indiceFinal = indice -1;
		
		if(indiceFinal >= taskrepo.getTarefas().size()|| indiceFinal < 0){
			Style.escrever("Erro! Tarefa inexistente");
			return;
		}
		
		Tarefa tarefaConcluida = taskrepo.getTarefas().get(indiceFinal);
		
		Style.escrever("Você vai concluir a tarefa: "+tarefaConcluida.getObjetivo(), indiceFinal);
		
		if(confirmacao())
		taskrepo.concluir(indiceFinal);
		
	}
	
	public void limparConcluidas() {
		
		if(!confirmacao()) return;
		
		taskrepo.limparConcluidas();
		
		Style.escrever("Tarefas concluidas limpadas da lista com sucesso");
		
	}

	public void apagarTarefas() {
		if(!confirmacao()) return;
		
		taskrepo.apagarTodasTarefas();
		Style.escrever("Lista de tarefas limpa com sucesso!");
	}
	
	public ArrayList<Tarefa> enviarCopia() {
		return new ArrayList<>(taskrepo.getTarefas());
	}
	
	private boolean confirmacao() {
		while(true) {
			Style.escrever("Confirma? S/N");
			
			String resposta = Input.pegaString();
			
			if(resposta.equalsIgnoreCase("s")) return true;
			if(resposta.equalsIgnoreCase("n")) return false;
			
			Style.escrever("Resposta inválida!");
		}
	}
	
	public boolean estaVazia() {
		return taskrepo.getTarefas().isEmpty();
	}
	
	
}
