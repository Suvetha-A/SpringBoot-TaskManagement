package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private int taskid ;
    private String taskHolderName ,taskDate,taskName ,taskStatus;
    
    
    Task() {}

    Task(int taskid, String taskHolderName ,String taskDate,String taskName,String taskStatus)

    {

        this.setTaskid(taskid);
        this.setTaskHolderName(taskHolderName);
        this.setTaskDate(taskDate);
        this.setTaskName(taskName);
        this.setTaskStatus(taskStatus);

    }

    public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	
	public String getTaskHolderName() {
		return taskHolderName;
	}

	public void setTaskHolderName(String taskHolderName) {
		this.taskHolderName = taskHolderName;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	

}
