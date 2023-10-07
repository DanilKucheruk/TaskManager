package dto;

import java.time.LocalDate;
import java.util.Objects;
import entity.Project;

public class ProjectDto {
	private Long id;
	private String name;
	private String description;
	private Long adminId;
	private LocalDate deadline;

	public ProjectDto(Long id, String name, String description, Long adminId, LocalDate deadline) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.adminId = adminId;
		this.deadline = deadline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, adminId, deadline);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Project project = (Project) o;
		return Objects.equals(o, project);

	}

	@Override
	public String toString() {
		return "Project{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\''
				+ ", adminId=" + adminId + ", deadline=" + deadline + '}';
	}
}
