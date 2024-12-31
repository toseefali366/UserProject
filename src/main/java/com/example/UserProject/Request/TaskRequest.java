package com.example.UserProject.Request;

import com.example.UserProject.model.Task;

public class TaskRequest {
    private Task.TaskStatus taskStatus;
    private String taskName;
    private Long userId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Task.TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Task.TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
