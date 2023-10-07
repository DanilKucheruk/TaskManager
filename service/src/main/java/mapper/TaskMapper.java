package mapper;

import dto.TaskDto;
import entity.Task;

public class TaskMapper implements Mapper<TaskDto,Task>{
	private TaskMapper() {}
	private static TaskMapper INSTANCE = new TaskMapper();
	public static TaskMapper getInstance() {
		return INSTANCE;
	}
	
	@Override
	public TaskDto mapFrom(Task object) {
		TaskDto taskDto = new TaskDto(
				object.getId(),
				object.getTitle(),
				object.getDeadline(),
				object.getProjectId()
				);
		return taskDto;
	}

}
