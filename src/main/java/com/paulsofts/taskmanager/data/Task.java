package com.paulsofts.taskmanager.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
	
	@Id
	private int taskId;
	@Field(name="Task Importance")
	private long taskSeverity;
	private String taskName;
	private String taskAssignee;
	@Field(name="Date")
	private Date date;

}
