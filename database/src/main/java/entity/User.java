package entity;

import java.util.Objects;

public class User {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Role role;
	private String departmentCode;

	public User(Long id, String email, String firstName, String lastName, String password, Role role,
			String departmentCode) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.setDepartmentCode(departmentCode);
	}

	public User(String email, String firstName, String lastName, String password, Role role, String departmentCode) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.departmentCode = departmentCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(o, user);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email);
	}

	@Override
	public String toString() {
		return "YourClassName{" + "id=" + id + ", email='" + email + '\'' + ", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + ", password='" + password + '\'' + ", role=" + role
				+ ", departmentCode=" + departmentCode + '}';
	}

}
