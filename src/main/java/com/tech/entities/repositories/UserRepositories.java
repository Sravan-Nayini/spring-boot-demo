package com.tech.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entities.User;

public interface UserRepositories extends JpaRepository<User, String> {

	User findByEmail(String email);

	List<User> findByNameLike(String name);

}
