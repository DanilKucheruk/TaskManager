package service;

import dao.ProjectDao;
import dto.CreateProjectDto;
import entity.Project;
import entity.User;
import mapper.CreateProjectMapper;
import mapper.ProjectMapper;

public class ProjectService {
	private ProjectService() {
	}

	private static final ProjectService INSTANCE = new ProjectService();

	public static ProjectService getInstance() {
		return INSTANCE;
	}

	private final ProjectDao projectDao = ProjectDao.getInstance();
	private final CreateProjectMapper createProjectMapper = CreateProjectMapper.getInstance();

	public Long crateProject(CreateProjectDto createProjectDto) {
		// maping
		Project projectEnt = createProjectMapper.mapFrom(createProjectDto);

		// ProjectDao save to database
		projectDao.save(projectEnt);

		return projectEnt.getId();
	}
}
