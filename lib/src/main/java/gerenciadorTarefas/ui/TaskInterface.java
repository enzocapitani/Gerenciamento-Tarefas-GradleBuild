package gerenciadorTarefas.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gerenciadorTarefas.model.Tarefa;
import gerenciadorTarefas.service.TaskService;
import gerenciadorTarefas.ui.style.Style;

public class TaskInterface {
	
	TaskService service;
	GerenciarTaskUi gerenciadorUi;
	
	Scanner scr;
	
	public TaskInterface(TaskService service) {
		this.service = service;
		scr = new Scanner(System.in);
		gerenciadorUi = new GerenciarTaskUi(service);
	}
	
	public void runInterface() {
		boolean rodando = true;
		
		System.out.println(Style.separador);
		Style.escrever("Bem-Vindo ao gerenciador de tarefas!");
		Style.escrever("O que temos para hoje?!");
		System.out.println(Style.separador);
		
		while(rodando) {
			
			Style.escrever("Menu Principal", 20);
			Style.escrever("1- Gerenciar minhas tarefas\n2- Sobre\n3- Sair", 10);
			
			switch (pegaInt()) {
				case 1 -> gerenciarTasksUi();
				case 2 -> Style.escrever("Excluir tarefas");
				case 3 -> {
					Style.escrever("Saindio");
					rodando = false;
				}	

			}
			
			
			
		}
		
	}
	
	private void gerenciarTasksUi() {
		gerenciadorUi.gerenciarTasks();
	}
	
	
	
	protected int pegaInt() {
		System.out.print("Resposta: ");
		int resposta = scr.nextInt();
		
		System.out.println(Style.separador);
		
		//Limpa o buffer, exclui o \n
		scr.nextLine();
		return resposta;
	}
	
	protected String pegaString() {
		System.out.print("Resposta: ");
		String resposta = scr.nextLine();
		
		System.out.println(Style.separador);
		
		return resposta;
	}
	
}