package mapper;

import dto.CreateTaskDto;
import entity.Task;
import util.LocalDateForrmater;

public class CreateTaskMapper implements Mapper<Task, CreateTaskDto> {
	private CreateTaskMapper() {
	}

	private static CreateTaskMapper INSTANCE = new CreateTaskMapper();

	public static CreateTaskMapper getInstance() {
		return INSTANCE;
	}

	@Override
	public Task mapFrom(CreateTaskDto object) {
		Task task = new Task(object.getTitle(), LocalDateForrmater.format(object.getDeadline()), object.getProjectId());
		return task;
	}

}
