package dao;

import entity.Task;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDao implements Dao<Long, Task> {
	private TaskDao() {
	}

	private static TaskDao INSTANCE = new TaskDao();

	public static TaskDao getInstance() {
		return INSTANCE;
	}

	List<Task> tasks;
	private static final String FIND_ALL_SQL = """
			SELECT * FROM task
			ORDER BY deadline
			;
			""";
	private static final String SAVE_TASK_SQL = """
				INSERT INTO task(title,deadline,project_id) VALUES(?,?,?);
			""";
	private static final String FIND_TASKS_BY_PROJECT_ID = """
			SELECT * FROM task WHERE project_id = ?
			""";
	private static final String DELETE_BY_ID = """
			DELETE FROM task WHERE id = ?
			""";

	@Override
	public List<Task> findAll() {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(FIND_ALL_SQL)) {
			tasks = new ArrayList<>();
			ResultSet resultSet = prSt.executeQuery();
			Task task = null;
			while (resultSet.next()) {
				task = taskBuilder(resultSet);
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public Optional<Task> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public Task save(Task entity) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(SAVE_TASK_SQL, Statement.RETURN_GENERATED_KEYS)) {
			prSt.setString(1, entity.getTitle());
			prSt.setObject(2, entity.getDeadline());
			prSt.setLong(3, entity.getProjectId());
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

	public List<Task> findTaskByProjectId(Long projectId) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(FIND_TASKS_BY_PROJECT_ID)) {
			tasks = new ArrayList<>();
			prSt.setLong(1, projectId);
			ResultSet resultSet = prSt.executeQuery();
			Task task = null;
			while (resultSet.next()) {
				task = taskBuilder(resultSet);
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public Task taskBuilder(ResultSet resultSet) {
		try {
			Task task = new Task(resultSet.getLong("id"), resultSet.getString("title"),
					resultSet.getDate("deadline").toLocalDate(), resultSet.getLong("project_id"));
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void deleteById(Long taskId) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(DELETE_BY_ID)) {
			prSt.setLong(1, taskId);
			prSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
