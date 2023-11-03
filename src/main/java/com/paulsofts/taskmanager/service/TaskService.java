package com.paulsofts.taskmanager.service;

import java.util.List;

import com.paulsofts.taskmanager.data.Task;

public interface TaskService {

	public Task createTask(Task task);
	public Task updateTask(Task task, int taskId);
	public Task getTaskById(int taskId);
	public List<Task> getAllTask();
	public String deleteTask(int taskId);

}
