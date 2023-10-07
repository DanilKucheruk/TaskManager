package service;

import java.util.Optional;
import dao.UserDao;
import dto.CreateUserDto;
import dto.UserDto;
import entity.User;
import mapper.CreateUserMapper;
import mapper.UserMapper;

public class UserService {
	private static final UserService INSTANCE = new UserService();

	public static UserService getInstance() {
		return INSTANCE;
	}

	private UserService() {
	}

	private final UserDao userDao = UserDao.getInstance();
	private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
	private final UserMapper userMapper = UserMapper.getInstance();

	public Long createUser(CreateUserDto createUserDto) {
		// maping
		User userEnt = createUserMapper.mapFrom(createUserDto);

		// userDao.save( to DB ) return id
		userDao.save(userEnt);
		return userEnt.getId();
	}

	public Optional<UserDto> login(String email, String password) {
		return userDao.findByEmailAndPassword(email, password).map(userMapper::mapFrom);
	}
}
