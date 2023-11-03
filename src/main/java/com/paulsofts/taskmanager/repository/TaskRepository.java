package com.paulsofts.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paulsofts.taskmanager.data.Task;

//we will pass the Task class and the data type of 
//id we have used in our Task class

//MongoRepository will provide the standard CRUD operations
public interface TaskRepository extends MongoRepository<Task, Integer> {

}
