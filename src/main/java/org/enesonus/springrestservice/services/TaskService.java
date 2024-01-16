package org.enesonus.springrestservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import org.enesonus.springrestservice.entities.Task;
import org.enesonus.springrestservice.repositories.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);

        return tasks;
    }

    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    public Task update(Task taskToUpdate) {
        return taskRepository.save(taskToUpdate);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}
