package gerenciadorTarefas.ui;

import java.util.ArrayList;

import gerenciadorTarefas.model.Tarefa;
import gerenciadorTarefas.service.TaskService;
import gerenciadorTarefas.ui.style.Style;

public class GerenciarTaskUi {
	
	TaskService service;
	
	private final String separador = "===========================================";
	
	public GerenciarTaskUi(TaskService taskservice) {
		this.service = taskservice;
	}
	
	
	public void gerenciarTasks() {
		Style.escrever("GERENCIADOR DE TAREFAS");
		Style.escrever("1- Mostrar tarefas\n2- Concluir tarefa\n3- Excluir todas as tarefas\n 4- Limpar Concluidas\n"+
		"5- Sair", 10);
		
		while(true) {
			mostrarTarefas();
			break;
		}
	}
	
	private void mostrarTarefas() {
		ArrayList<Tarefa> tarefas = service.enviarCopia();
		Style.escrever("Mostrando Tarefas...\n");
		
		for(int i = 0 ; i < tarefas.size(); i++) {
			System.out.print((i+1)+" : ");
			tarefas.get(i).mostrar();
		}
		
		System.out.println(separador);
		
	}
	
}
