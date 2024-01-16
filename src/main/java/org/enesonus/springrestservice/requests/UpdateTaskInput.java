package org.enesonus.springrestservice.requests;

import org.enesonus.springrestservice.entities.TaskStatusEnum;

import java.util.Date;

public record UpdateTaskInput(String name, String description, TaskStatusEnum status, Date dueDate) {

}
