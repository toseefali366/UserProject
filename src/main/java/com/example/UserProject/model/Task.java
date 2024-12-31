package com.example.UserProject.model;

import jakarta.persistence.*;

@Entity
public class Task {
    public enum TaskStatus {
        STARTED,
        IN_PROGRESS,
        COMPLETED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private TaskStatus taskStatus;
    private String taskName;
    @ManyToOne
    private User user;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

