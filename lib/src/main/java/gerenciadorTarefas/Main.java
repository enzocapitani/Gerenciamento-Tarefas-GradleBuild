package gerenciadorTarefas;

import gerenciadorTarefas.repository.InMemoryTaskRepository;
import gerenciadorTarefas.service.TaskService;
import gerenciadorTarefas.ui.TaskInterface;

public class Main {
	public static void main(String args[]) {
		InMemoryTaskRepository taskRepo = new InMemoryTaskRepository();
		TaskService taskService = new TaskService(taskRepo);
		TaskInterface taskInterface = new TaskInterface(taskService);
		
		taskInterface.runInterface();
		
	}
}
