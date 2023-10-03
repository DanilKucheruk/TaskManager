package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Role;
import entity.User;
import util.ConnectionManager;

public class UserDao implements Dao<Long,User>{
	private static final UserDao INSTANCE = new UserDao();
	public static UserDao getInstance() {
		return INSTANCE;
	}
	private UserDao() {}
	private List<User> usersList;
	private List<String> fullUserNames;
	private final String SAVE_SQL = """
			INSERT INTO users(email,first_name,last_name,password,role, department_code) VALUES(?,?,?,?,?,?)
			""";
	private final String GET_BY_EMEIL_AND_PASSWORD ="""
			SELECT * FROM users
			WHERE email = ? AND password = ?;
			""";
	private final String SQL_FIND_ALL = """
			SELECT * FROM users
			""";
	private final String SQL_FIND_BY_ID = """
			SELECT * from users
			WHERE id = ?
			""";
	private final String SQL_GET_USER_NAMES = """
			SELECT CONCAT(first_name, ' ', last_name) AS full_name 
			FROM users
			WHERE department_code = ?;
			""";
	
	@Override
	public List<User> findAll() {
		usersList = new ArrayList<>();
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(SQL_FIND_ALL) ){
			ResultSet resultSet = prSt.executeQuery();
			User user = null;
			while(resultSet.next()) {
				user = userBuilder(resultSet);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	private User userBuilder(ResultSet resultSet) throws SQLException {
		return new User(
				resultSet.getLong("id"),
				resultSet.getString("email"),
				resultSet.getString("first_name"),
				resultSet.getString("last_name"),
				resultSet.getString("password"),
				Role.valueOf(resultSet.getString("role")),
				resultSet.getString("department_code")
				);
	}
	public List<String> getUserNames(String departmentCode){
		fullUserNames = new ArrayList<>();
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(SQL_GET_USER_NAMES)){
			prSt.setString(1, departmentCode);
			ResultSet resultSet = prSt.executeQuery();
			while(resultSet.next()) {
				fullUserNames.add(resultSet.getString("full_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fullUserNames;
	}
	@Override
	public Optional<User> findById(Long id) {
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(SQL_FIND_BY_ID) ){
			prSt.setLong(1, id);
			User user = null;
			ResultSet resultSet =prSt.executeQuery();
			if(resultSet.next()) {
				user = userBuilder(resultSet);
				return Optional.ofNullable(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	@Override
	public User save(User entity) {
		try(Connection connection = ConnectionManager.open(); PreparedStatement prSt = connection.prepareStatement(SAVE_SQL,Statement.RETURN_GENERATED_KEYS)){
			prSt.setString(1, entity.getEmail());
			prSt.setString(2, entity.getFirstName());
			prSt.setString(3, entity.getLastName());
			prSt.setString(4, entity.getPassword());
			prSt.setString(5, entity.getRole().name());
			prSt.setString(6, entity.getDepartmentCode());
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
	
	public Optional<User> findByEmailAndPassword(String email, String password) {
	    try (Connection connect = ConnectionManager.open();
	         PreparedStatement prSt = connect.prepareStatement(GET_BY_EMEIL_AND_PASSWORD)) {
	        prSt.setString(1, email);
	        prSt.setString(2, password);
	        ResultSet rs = prSt.executeQuery();
	        User user = null;
	        if (rs.next()) {
	            user = userBuilder(rs);
	        }
	        return Optional.ofNullable(user);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return Optional.empty();
	}

	

	
}
