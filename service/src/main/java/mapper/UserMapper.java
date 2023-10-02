package mapper;

import dto.UserDto;
import entity.User;
import entity.Role;
public class UserMapper implements Mapper<UserDto,User> {
	private static final UserMapper INSTANCE = new UserMapper();
	public static UserMapper getInstance() {
		return INSTANCE;
	}
	@Override
	public UserDto mapFrom(User object) {
		UserDto userDto = new UserDto(
				object.getId(),
				object.getEmail(),
				object.getFirstName(),
				object.getLastName(),
				object.getPassword(),
				object.getRole(),
				object.getDepartmentCode()
				);
		return userDto;
	}

}
