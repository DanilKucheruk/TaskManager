package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import entity.ProjectParticipant;
import util.ConnectionManager;

public class ProjectParticipantDao implements Dao<Long, ProjectParticipant> {
	private static final ProjectParticipantDao INSTANCE = new ProjectParticipantDao();

	public static ProjectParticipantDao getInstance() {
		return INSTANCE;
	}

	private ProjectParticipantDao() {
	}

	private final String SAVE_SQL = """
			INSERT INTO project_participants(user_id,project_id) VALUES(?,?);
			""";

	@Override
	public List<ProjectParticipant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProjectParticipant> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ProjectParticipant save(ProjectParticipant entity) {
		try (Connection connection = ConnectionManager.open();
				PreparedStatement prSt = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
			prSt.setLong(1, entity.getUserId());
			prSt.setLong(2, entity.getProjectId());
			prSt.executeUpdate();
			ResultSet keys = prSt.getGeneratedKeys();
			keys.next();
			entity.setId(keys.getLong(1));
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
