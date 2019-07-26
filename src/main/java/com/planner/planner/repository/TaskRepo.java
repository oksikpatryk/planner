package com.planner.planner.repository;

import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    @Query(nativeQuery = true, value = "select * from tasks join projects p on tasks.project_id = p.id join projects_users pu on p.id = pu.projects_id " +
            "where date(close_date) = CURDATE() + INTERVAL :intervalDays DAY and pu.users_id = :userId order by priority;")
    List<Task> findAllTaskWithIntervalInDaysOrderByPriority(@Param("intervalDays") int intervalDays,@Param("userId") Long userId);
    @Query(nativeQuery = true, value = "select * from tasks join projects p on tasks.project_id = p.id join projects_users pu on p.id = pu.projects_id " +
            "where date(close_date) < CURDATE() + INTERVAL -1 DAY and pu.users_id = :userId order by priority;")
    List<Task> findAllByCloseDateAfter(@Param("userId") Long userId);
    @Query(nativeQuery = true, value = "select * from tasks t join projects p on t.project_id = p.id join projects_users pu on p.id = pu.projects_id " +
            "where pu.users_id = :userId and t.name like CONCAT('%',:searchedTask,'%') order by priority;")
    List<Task> findAllByNameContaining(@Param("searchedTask")String searchedTask, @Param("userId") Long user);
}
