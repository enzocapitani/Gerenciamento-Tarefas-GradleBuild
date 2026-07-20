package repository;

import java.util.ArrayList;

import model.Tarefa;

public class InMemoryTaskRepository {
	
	private ArrayList<Tarefa> tarefas;
	
	public InMemoryTaskRepository() {
		tarefas = new ArrayList<>();
		tarefas.add(new Tarefa(1, "Corrigir prova de calculo"));
		tarefas.add(new Tarefa(5, "Estudar Quimica organica"));
	}
	
	public void concluir(int index){
		tarefas.get(index).concluir();
	}
	
	public void limparConcluidas() {
		tarefas.removeIf(tarefa -> tarefa.isConcluida());
	}
	
	public void apagarTodasTarefas() {
		tarefas.clear();
	}
	
	public void adcionarTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	//Getter retornando nova lista para a original nao ser modificada
	public ArrayList<Tarefa> getTarefas() {
		return new ArrayList<>(tarefas);
	}
	
}
