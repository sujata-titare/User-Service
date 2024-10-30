package com.TaskManagementService.Service;

import com.TaskManagementService.Entity.Task;
import com.TaskManagementService.Exception.TaskNotFoundException;
import com.TaskManagementService.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id); // This will throw an exception if not found
       task.setTitle(taskDetails.getTitle());

        task.setDescriction(task.getDescriction());

        return taskRepository.save(task);
    }
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

}
