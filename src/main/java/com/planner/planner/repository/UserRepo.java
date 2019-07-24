package com.planner.planner.repository;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}