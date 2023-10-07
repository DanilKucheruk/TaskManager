package mapper;

import dto.CreateProjectDto;
import entity.Project;
import util.LocalDateForrmater;

public class CreateProjectMapper implements Mapper<Project, CreateProjectDto> {
	private CreateProjectMapper() {
	}

	private static final CreateProjectMapper INSTANCE = new CreateProjectMapper();

	public static CreateProjectMapper getInstance() {
		return INSTANCE;
	}

	@Override
	public Project mapFrom(CreateProjectDto object) {
		Project project = new Project(object.getName(), object.getDescription(), object.getAdminId(),
				LocalDateForrmater.format(object.getDeadline()));
		return project;
	}
}
