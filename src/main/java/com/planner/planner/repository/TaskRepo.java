package com.planner.planner.repository;

import com.planner.planner.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    @Query(nativeQuery = true, value = "select * from tasks where date(close_date) = CURDATE() + INTERVAL :intervalDays DAY order by priority;")
    List<Task> findAllTaskWithIntervalInDaysOrderByPriority(@Param("intervalDays") int intervalDays);
    @Query(nativeQuery = true, value = "select * from tasks where date(close_date) < CURDATE() + INTERVAL -1 DAY order by priority;")
    List<Task> findAllByCloseDateAfter();
    List<Task> findAllByNameContaining(String searchedTask);
}
