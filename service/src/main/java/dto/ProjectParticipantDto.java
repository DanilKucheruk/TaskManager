package dto;

public class ProjectParticipantDto {
	private Long id;
	private Long userId;
	private Long projectId;

	public ProjectParticipantDto(Long id, Long userId, Long projectId) {
		this.id = id;
		this.userId = userId;
		this.projectId = projectId;
	}

	public ProjectParticipantDto(Long userId, Long projectId) {
		this.userId = userId;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProject_id(Long projectId) {
		this.projectId = projectId;
	}
}
