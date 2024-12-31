package com.example.UserProject.service;

import com.example.UserProject.Request.TaskRequest;
import com.example.UserProject.model.Task;
import com.example.UserProject.model.User;
import com.example.UserProject.repository.TaskRepository;
import com.example.UserProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public void post(TaskRequest taskRequest) {
        Task task=new Task();
        User user = userRepository.findById(taskRequest.getUserId())
                .orElseThrow(()->new RuntimeException("error"));
        task.setUser(user);
        task.setTaskStatus(taskRequest.getTaskStatus());
        task.setTaskName(taskRequest.getTaskName());
        taskRepository.save(task);
    }

    public List<Task> findAll() {
    List<Task> l1= taskRepository.findAll();
    return l1;
    }

    public Task findById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()->new RuntimeException("Error"));
        return task;
    }

    public void updateTask(TaskRequest taskRequest, Long taskId) {
        Task task=taskRepository.findById(taskId).orElseThrow(()->new RuntimeException("Error"));
        if(taskRequest.getTaskStatus()!=null){
            task.setTaskStatus(taskRequest.getTaskStatus());
        }
        if(taskRequest.getTaskName()!=null){
            task.setTaskName(taskRequest.getTaskName());
        }
        if(taskRequest.getUserId()!=null){
            task.setUser(userRepository.findById(taskRequest.getUserId()).orElseThrow(()->new RuntimeException("error")));

        }
        taskRepository.save(task);
    }

    public void deleteById(Long taskId) {
        Task task=taskRepository.findById(taskId).orElseThrow(()->new RuntimeException("error"));
        taskRepository.delete(task);
    }

    public List<Task> findTaskByUserId(Long userId) {
        return taskRepository.FindTaskByUserId(userId);
    }
}
