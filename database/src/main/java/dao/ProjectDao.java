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
public class ProjectDao implements Dao<Long,Project>{
	private ProjectDao() {}
	private static final ProjectDao INSTANCE = new ProjectDao();
	public static ProjectDao getInstance() {
		return INSTANCE;
	}
	private List<Project> projects;
	private static final String SAVE_PROJECT_SQL= """
				INSERT INTO project(name,description,admin_id,deadline) VALUES(?,?,?,?);
			""";
	private static final String FIND_ALL_SQL ="""
			SELECT * FROM project;
			""";
	@Override
	public List<Project> findAll() {
		
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(FIND_ALL_SQL)){
			projects = new ArrayList<>();
			ResultSet resultSet = prSt.executeQuery();
			Project project = null;
			while(resultSet.next()) {
				project = projectBuilder(resultSet);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
	@Override
	public Optional<Project> findById(Long id) {
		return Optional.empty();
	}
	@Override
	public Project save(Project entity) {
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(SAVE_PROJECT_SQL,Statement.RETURN_GENERATED_KEYS)){
			prSt.setString(1, entity.getName());
			prSt.setString(2, entity.getDescription());
			prSt.setLong(3, entity.getAdminId());
			prSt.setObject(4, entity.getDeadline());
			prSt.executeUpdate();
			ResultSet keys = prSt.getGeneratedKeys();
			keys.next();
			entity.setId(keys.getObject("id",Long.class));
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Project projectBuilder(ResultSet resultSet){
		try {
			Project project = new Project(
					resultSet.getLong("id"),
					resultSet.getString("name"),
					resultSet.getString("description"),
					resultSet.getLong("admin_id"),
					resultSet.getDate("deadline").toLocalDate()
					);
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
