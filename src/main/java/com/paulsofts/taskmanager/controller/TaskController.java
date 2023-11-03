package com.paulsofts.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulsofts.taskmanager.data.Task;
import com.paulsofts.taskmanager.service.TaskServiceImpl;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	//Create
	@PostMapping("/create")
	public Task createTask(@RequestBody Task task) {
		Task createdTask = this.taskServiceImpl.createTask(task);
		return createdTask;
	}
	
	//Update
	@PostMapping("/update/{taskId}")
	public Task updateTask(@RequestBody Task task, @PathVariable("taskId") int taskId) {
		Task updatedTask = this.taskServiceImpl.updateTask(task, taskId);
		return updatedTask;
	}
	
	//Get - Single Task
	@GetMapping("/get/{taskId}")
	public Task getTaskById(@PathVariable("taskId") int taskId) {
		Task taskById = this.taskServiceImpl.getTaskById(taskId);
		return taskById;
	}
	
	//Get - All Tasks
	@GetMapping("/get")
	public List<Task> getAllTask(@RequestHeader HttpHeaders httpHeaders){
		List<Task> taskList =  this.taskServiceImpl.getAllTask();
		return taskList;
	}
	
	//Delete
	@DeleteMapping("/delete/{taskId}")
	public String deleteTask(@PathVariable("taskId") int taskId) {
		String taskDeleted = this.taskServiceImpl.deleteTask(taskId);
		return taskDeleted;
	}
	
}
