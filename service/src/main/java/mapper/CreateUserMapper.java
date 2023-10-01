package mapper;

import dto.CreateUserDto;
import entity.User;
import entity.Role;

public class CreateUserMapper implements Mapper<User,CreateUserDto>{
	public static final CreateUserMapper INSTANCE = new CreateUserMapper();
	public static CreateUserMapper getInstance(){
		return INSTANCE;
	}
	private CreateUserMapper() {}
	@Override
	public User mapFrom(CreateUserDto object) {
		User user = new User(
				object.getEmail(),
				object.getFirstName(),
				object.getLastName(),
				object.getPassword(),
				Role.valueOf(object.getRole()),
				object.getDepartmentCode());
		return user;

	}
}	
