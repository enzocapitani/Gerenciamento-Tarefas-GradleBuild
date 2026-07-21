package ui;

import java.util.ArrayList;

import model.Tarefa;
import service.TaskService;
import ui.style.Style;

public class GerenciarTaskUi {
	
	TaskService service;
	
	public GerenciarTaskUi(TaskService taskservice) {
		this.service = taskservice;
	}
	
	
	public void gerenciarTasks() {
		boolean rodando = true;
		
		Limpador.limpar();
		
		while(rodando) {

			System.out.println(Style.separador);
			Style.escrever("GERENCIADOR DE TAREFAS");
			System.out.println(Style.separador);

			Style.escrever("1- Mostrar tarefas\n2- Criar Tarefa\n3- Concluir tarefa\n4- Excluir todas as tarefas\n5- Limpar Concluidas\n"+
					"6- Sair", 10);
			System.out.println(Style.separador);
			
			switch (Input.pegaInt()) {


			case 1 -> mostrarTarefas();
			case 2 -> criarTarefa();
			case 3 -> concluirTarefa();
			case 4 -> excluirTarefas();
			case 5 -> limparConcluidas();
			case 6 -> rodando = sair();

			}
		}
	}
	
	private boolean mostrarTarefas() {
		Limpador.limpar();

		ArrayList<Tarefa> tarefas = service.enviarCopia();
		
		if(estaVazia()) return false;

		System.out.println(Style.separador);
		Style.escrever("Mostrando Tarefas\n");

		for(int i = 0 ; i < tarefas.size(); i++) {
			System.out.print((i+1)+" : "+tarefas.get(i).mostrar()+"\n");
		}

		return true;
		
	}
	
	private void criarTarefa() {
		Limpador.limpar();

		System.out.println(Style.separador);
		Style.escrever("Criação de tarefa");
		System.out.println(Style.separador);

		Style.escrever("Qual será a tarefa?");
		String objetivo = Input.pegaString();
		
		Style.escrever("Qual será o prazo da tarefa?");
		int prazo = Input.pegaInt();
		
		service.adicionarTarefa(objetivo, prazo);

		Limpador.limpar();
	}
	
	private void concluirTarefa() {
		Limpador.limpar();
		if(!mostrarTarefas()) return;
		
		Style.escrever("Insira o número da tarefa que deseja terminar : ");
		int indiceTarefa = Input.pegaInt();
		
		service.concluirTarefa(indiceTarefa);
		
	}
	
	private void limparConcluidas() {
		Limpador.limpar();
		if(!mostrarTarefas()) return;
		Style.escrever("Você vai limpar as tarefas concluidas");
		
		service.limparConcluidas();
	}
	
	private void excluirTarefas() {
		Limpador.limpar();
		if(!mostrarTarefas()) return;
		
		Style.escrever("Você vai limpar TODAS as tarefas");
		Style.escrever("ATENÇÃO! Essa ação é irreversível.");
		
		service.apagarTarefas();
		
	}
	
	private boolean sair() {
		Limpador.limpar();
		Style.escrever("Saindo . . .");
		return false;
	}
	
	private boolean estaVazia() {
		Limpador.limpar();
		if(service.estaVazia()) {
			Style.escrever("Lista de tarefas está vazia...");
			return true;
		}
		
		return false;
		
	}
	
}
