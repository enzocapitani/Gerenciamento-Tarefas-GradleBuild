package gerenciadorTarefas.ui;

import java.util.ArrayList;

import gerenciadorTarefas.model.Tarefa;
import gerenciadorTarefas.service.TaskService;
import gerenciadorTarefas.ui.style.Style;

public class GerenciarTaskUi {
	
	TaskService service;
	
	public GerenciarTaskUi(TaskService taskservice) {
		this.service = taskservice;
	}
	
	
	public void gerenciarTasks() {
		boolean rodando = true;
		
		Style.escrever("GERENCIADOR DE TAREFAS");
		System.out.println(Style.separador);
		
		while(rodando) {
			Style.escrever("1- Mostrar tarefas\n2- Concluir tarefa\n3- Excluir todas as tarefas\n4- Limpar Concluidas\n"+
					"5- Sair", 10);
			System.out.println(Style.separador);
			
			switch (Input.pegaInt()) {
			case 1 -> mostrarTarefas();
			case 2 -> concluirTarefa();
			case 3 -> System.out.println("em build");
			case 4 -> rodando = false;
			}
			
		}
	}
	
	private void mostrarTarefas() {
		ArrayList<Tarefa> tarefas = service.enviarCopia();
		Style.escrever("Mostrando Tarefas...\n");
		
		for(int i = 0 ; i < tarefas.size(); i++) {
			System.out.print((i+1)+" : ");
			tarefas.get(i).mostrar();
		}
		
		System.out.println(Style.separador);
		
	}
	
	private void concluirTarefa() {
		
		ArrayList<Tarefa> tarefas = service.enviarCopia();
		mostrarTarefas();
		System.out.println(Style.separador);
		
		Style.escrever("Insira o número da tarefa que deseja terminar : ");
		int indiceTarefa = Input.pegaInt();
		
		service.concluirTarefa(indiceTarefa);
		
	}
	
}
