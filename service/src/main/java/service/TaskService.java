package service;

import dao.TaskDao;
import dto.CreateProjectDto;
import dto.CreateTaskDto;
import entity.Project;
import entity.Task;
import mapper.CreateTaskMapper;
import mapper.TaskMapper;

public class TaskService {
	private TaskService() {
	}

	private static TaskService INSTANCE = new TaskService();

	public static TaskService getInstance() {
		return INSTANCE;
	}

	private final TaskDao taskDao = TaskDao.getInstance();
	private final CreateTaskMapper crateTaskMapper = CreateTaskMapper.getInstance();

	public Long crateTask(CreateTaskDto createTaskDto) {
		// maping
		Task taskEnt = crateTaskMapper.mapFrom(createTaskDto);

		// ProjectDao save to database
		taskDao.save(taskEnt);

		return taskEnt.getId();
	}

}
