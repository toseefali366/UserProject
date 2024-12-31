package com.example.UserProject.controller;

import com.example.UserProject.Request.TaskRequest;
import com.example.UserProject.model.Task;
import com.example.UserProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/Task")
  public void post(@RequestBody TaskRequest taskRequest){
        taskService.post(taskRequest);
    }
    @GetMapping("findAll")
    public List<Task> findAll(){
       return taskService.findAll();
    }
    @GetMapping("/FindById{taskId}")
    public Task FindById(@PathVariable Long taskId){
        return taskService.findById(taskId);
    }
    @PutMapping("/update/{taskId}")
    public void updateTask(@RequestBody TaskRequest taskRequest,@PathVariable Long taskId){
        taskService.updateTask(taskRequest,taskId);
    }
    @DeleteMapping("/delete/{taskId}")
    public void deleteById(@PathVariable Long taskId){
        taskService.deleteById(taskId);
    }

    @GetMapping("/findTaskByUserId/{userId}")
    public List<Task> findTaskByUserId(@PathVariable Long userId){
    return  taskService.findTaskByUserId(userId);
    }

}
