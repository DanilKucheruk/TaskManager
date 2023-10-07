package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Project;
import util.ConnectionManager;

public class ProjectDao implements Dao<Long, Project> {
	private ProjectDao() {
	}

	private static final ProjectDao INSTANCE = new ProjectDao();

	public static ProjectDao getInstance() {
		return INSTANCE;
	}

	private List<Project> projects;
	private static final String SAVE_PROJECT_SQL = """
				INSERT INTO project(name,description,admin_id,deadline) VALUES(?,?,?,?);
			""";
	private static final String FIND_ALL_SQL = """
			SELECT * FROM project
			ORDER BY deadline
			;
			""";
	private static final String FIND_ALL_BY_ID_SQL = """
			SELECT * FROM project
			WHERE id = ?
			ORDER BY deadline
			;
			""";
	private static final String FIND_ALL_PROJECTS_BY_PARTICIPANT_ID_SQL = """
			SELECT * FROM project AS pj
			JOIN project_participants AS pj_part ON  pj_part.project_id = pj.id
			WHERE  pj_part.user_id = ?;
			""";
	private static final String DELETE_PROJECT_BY_ID_SQL = """
			DELETE FROM project WHERE id =?;
			""";

	@Override
	public List<Project> findAll() {

		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(FIND_ALL_SQL)) {
			projects = new ArrayList<>();
			ResultSet resultSet = prSt.executeQuery();
			Project project = null;
			while (resultSet.next()) {
				project = projectBuilder(resultSet);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	public boolean deleteById(Long projectId) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(DELETE_PROJECT_BY_ID_SQL)) {
			prSt.setLong(1, projectId);
			return prSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Optional<Project> findById(Long id) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(FIND_ALL_BY_ID_SQL)) {
			prSt.setLong(1, id);
			ResultSet resultSet = prSt.executeQuery();
			Project project = null;
			while (resultSet.next()) {
				project = projectBuilder(resultSet);
				return Optional.ofNullable(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Project save(Project entity) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(SAVE_PROJECT_SQL,
						Statement.RETURN_GENERATED_KEYS)) {
			prSt.setString(1, entity.getName());
			prSt.setString(2, entity.getDescription());
			prSt.setLong(3, entity.getAdminId());
			prSt.setObject(4, entity.getDeadline());
			prSt.executeUpdate();
			ResultSet keys = prSt.getGeneratedKeys();
			keys.next();
			entity.setId(keys.getLong("id"));
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Project> findAllProjectsByIdParticipantsId(Long id) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(FIND_ALL_PROJECTS_BY_PARTICIPANT_ID_SQL)) {
			projects = new ArrayList<>();
			prSt.setLong(1, id);
			ResultSet resultSet = prSt.executeQuery();
			Project project = null;
			while (resultSet.next()) {
				project = projectBuilder(resultSet);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	public Project projectBuilder(ResultSet resultSet) {
		try {
			Project project = new Project(resultSet.getLong("id"), resultSet.getString("name"),
					resultSet.getString("description"), resultSet.getLong("admin_id"),
					resultSet.getDate("deadline").toLocalDate());
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
