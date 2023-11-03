package com.paulsofts.taskmanager.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulsofts.taskmanager.data.Task;
import com.paulsofts.taskmanager.repository.TaskRepository;

//Annotating this class with the @Service annotation 
//so that its life cycle is managed and handled by the spring container
@Service
public class TaskServiceImpl implements TaskService {
	
	//auto-wiring TaskRepository to perform persistence operations
	@Autowired
	private TaskRepository taskRepository;
	
	
	@Override
	public Task createTask(Task task) {
		Date date = new Date();
		task.setDate(date);
		Task taskSavedToDB = this.taskRepository.save(task);
		return taskSavedToDB;
	}

	@Override
	public Task updateTask(Task task, int taskId) {
		Task taskToBeUpdate = this.taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
		taskToBeUpdate.setTaskName(task.getTaskName());
		taskToBeUpdate.setTaskSeverity(task.getTaskSeverity());
		taskToBeUpdate.setTaskAssignee(task.getTaskAssignee());
		return this.taskRepository.save(taskToBeUpdate);
	}

	@Override
	public Task getTaskById(int taskId) {
		Task taskById = this.taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
		return taskById;
	}

	@Override
	public List<Task> getAllTask() {
		//findAll method will return the list of all the tasks
		List<Task> taskList = this.taskRepository.findAll();
		return taskList;
	}

	@Override
	public String deleteTask(int taskId) {
		this.taskRepository.deleteById(taskId);
		return "Task with taskId " + taskId + " deleted successfully";
	}

}
