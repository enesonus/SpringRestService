package org.enesonus.springrestservice.controllers;

import org.enesonus.springrestservice.entities.Task;
import org.enesonus.springrestservice.requests.CreateTaskInput;
import org.enesonus.springrestservice.requests.UpdateTaskInput;
import org.enesonus.springrestservice.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    public TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskInput createTaskInput) {
        Task taskCreated = taskService.create(createTaskInput.toTask());

        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-tasks")
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.findAll();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        Optional<Task> optionalTask = taskService.findById(id);

        if (optionalTask.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id,
                                           @RequestBody UpdateTaskInput updateTaskInput) {
        Optional<Task> optionalTask = taskService.findById(id);

        if (optionalTask.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task taskToUpdate = optionalTask.get();

        // Update only if new value is provided
        if (updateTaskInput.name() != null) {
            taskToUpdate.setName(updateTaskInput.name());
        }

        if (updateTaskInput.description() != null) {
            taskToUpdate.setDescription(updateTaskInput.description());
        }

        if (updateTaskInput.status() != null) {
            taskToUpdate.setStatus(updateTaskInput.status());
        }

        if (updateTaskInput.dueDate() != null) {
            taskToUpdate.setDueDate(updateTaskInput.dueDate());
        }

        Task taskUpdated = taskService.update(taskToUpdate);

        return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskService.findById(id);

        if (optionalTask.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

