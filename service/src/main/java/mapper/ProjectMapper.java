package mapper;

import dto.ProjectDto;
import entity.Project;

public class ProjectMapper implements Mapper<ProjectDto, Project> {
	private static final ProjectMapper INSTANCE = new ProjectMapper();

	public static ProjectMapper getInstance() {
		return INSTANCE;
	}

	private ProjectMapper() {
	}

	@Override
	public ProjectDto mapFrom(Project object) {
		ProjectDto projectDto = new ProjectDto(object.getId(), object.getName(), object.getDescription(),
				object.getAdminId(), object.getDeadline());
		return projectDto;
	}

}
