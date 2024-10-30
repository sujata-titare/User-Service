package com.TaskManagementService.Repository;

import com.TaskManagementService.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
