package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usertable")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	private String userName;
	private String teamName;
	private String projectName;
	private String role;
	private String contactNumber;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="project")
	private ProjectEntity project;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="task", referencedColumnName = "userid")
	private List<TaskEntity> task;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int userId, String userName, String teamName, String projectName, String role,
			String contactNumber, String email, ProjectEntity project, List<TaskEntity> task) {
		super();
		UserId = userId;
		this.userName = userName;
		this.teamName = teamName;
		this.projectName = projectName;
		this.role = role;
		this.contactNumber = contactNumber;
		this.email = email;
		this.project = project;
		this.task = task;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public List<TaskEntity> getTask() {
		return task;
	}

	public void setTask(List<TaskEntity> task) {
		this.task = task;
	}
	
}
