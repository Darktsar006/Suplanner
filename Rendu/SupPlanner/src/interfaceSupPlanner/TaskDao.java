package interfaceSupPlanner;

import managerSupPlanner.Task;

public interface TaskDao {
	public Task[] displayAllTask();
	public boolean createTask(String name, int number, int completion);
	boolean modifyTask(int idT, String name, int numberX, int completionX);
}
