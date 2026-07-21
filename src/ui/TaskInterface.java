package ui;

import java.util.Scanner;

import service.TaskService;
import ui.style.Style;

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
			
			int escolha = Input.pegaInt();

			switch (escolha) {
				case 1 -> gerenciarTasksUi();
				case 2 -> sobre();
				case 3 -> {
					Style.escrever("Até logo!\nSaindo...");
					rodando = false;
				}
				
			}
			
		}
		
	}
	
	private void gerenciarTasksUi() {
		gerenciadorUi.gerenciarTasks();
	}
	
	private void sobre(){
		Style.escrever("Desenvolvimento: Enzo Capitani\nDesign: Enzo Capitani\nArquitetura de software:Enzo Capitani", 10);
		System.out.println(Style.separador);
	}

}