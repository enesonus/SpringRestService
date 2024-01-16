package org.enesonus.restservice.requests;

import org.enesonus.restservice.entities.TaskStatusEnum;

import java.util.Date;

public record UpdateTaskInput(String name, String description, TaskStatusEnum status, Date dueDate) {

}
