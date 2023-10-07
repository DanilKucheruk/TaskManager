package dto;

public class CreateTaskDto {
	private String title;
	private String deadline;
	private Long projectId;

	public CreateTaskDto(String title, String deadline, Long projectId) {
		this.title = title;
		this.deadline = deadline;
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}
