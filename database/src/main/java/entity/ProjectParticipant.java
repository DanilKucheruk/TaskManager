package entity;

import java.util.Objects;

public class ProjectParticipant {
	private Long id;
	private Long userId;
	private Long projectId;

	public ProjectParticipant(Long id, Long userId, Long projectId) {
		this.id = id;
		this.userId = userId;
		this.projectId = projectId;
	}

	public ProjectParticipant(Long userId, Long projectId) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ProjectParticipant that = (ProjectParticipant) o;
		return Objects.equals(id, that.id) && Objects.equals(userId, that.userId)
				&& Objects.equals(projectId, that.projectId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, projectId);
	}
}
