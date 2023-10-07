package dto;

import java.time.LocalDate;
import java.util.Objects;

import entity.Project;

public class TaskDto {
	private Long id;
	private String title;
	private LocalDate deadline;
	private Long projectId;

	public TaskDto(Long id, String title, LocalDate deadline, Long projectId) {
		this.id = id;
		this.title = title;
		this.deadline = deadline;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
	public int hashCode() {
		return Objects.hash(id, title, projectId);
	}
}