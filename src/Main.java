
import repository.InMemoryTaskRepository;
import service.TaskService;
import ui.TaskInterface;

public class Main {
	public static void main(String args[]) {
		InMemoryTaskRepository taskRepo = new InMemoryTaskRepository();
		TaskService taskService = new TaskService(taskRepo);
		TaskInterface taskInterface = new TaskInterface(taskService);
		
		taskInterface.runInterface();
		
	}
}
