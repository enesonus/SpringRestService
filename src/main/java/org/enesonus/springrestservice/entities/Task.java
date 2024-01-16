package org.enesonus.restservice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false, columnDefinition = "varchar(20) not null default 'PENDING'")
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

    @Column(name = "due_date")
    private Date dueDate;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Task() {
    }

    public Task(String name,
                String description,
                TaskStatusEnum status,
                Date dueDate,
                Date createdAt,
                Date updatedAt) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public Task setStatus(TaskStatusEnum status) {
        this.status = status;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Task setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Task setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Task setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status && Objects.equals(dueDate, task.dueDate) && Objects.equals(createdAt, task.createdAt) && Objects.equals(updatedAt, task.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, dueDate, createdAt, updatedAt);
    }
}