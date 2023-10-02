package dto;
import java.time.LocalDate;
import java.util.Objects;

import entity.Project;

public class CreateProjectDto {
	private String name;
	private String description;
	private String adminId;
	String deadline;
	public CreateProjectDto(String name, String description, String adminId, String deadline) {
        this.name = name;
        this.description = description;
        this.adminId = adminId;
        this.deadline = deadline;
    }

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

