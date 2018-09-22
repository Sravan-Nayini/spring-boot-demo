package com.tech.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entities.Task;
import com.tech.entities.User;

public interface TaskRepositories extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
