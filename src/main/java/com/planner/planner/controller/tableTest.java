package com.planner.planner.controller;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;
import com.planner.planner.service.ProjectService;
import com.planner.planner.service.TaskService;
import com.planner.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class tableTest {
    private ProjectService projectService;
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public tableTest(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @ModelAttribute("projects")
    public List<Project> projectList() {
        return projectService.findAllWithTasks();
    }

    @ModelAttribute("todayTasks")
    public List<Task> todayTasks() {
        return taskService.findAllTaskWithIntervalInDaysOrderByPriority(0);
    }

    @ModelAttribute("overdueTasks")
    public List<Task> overdueTasks() {
        return taskService.findAllOverdueTasks();
    }

    @ModelAttribute("tomorrow")
    public String tomorrow() {
        return LocalDate.now().plusDays(1).toString();
    }



    @PostMapping("/searchedTask")
    public String searchedTask(@RequestParam String searchedTask, Model model){
        model.addAttribute("searchedTasks", taskService.findAllByNameContaining(searchedTask));
        return "searchedTask";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String table() {
        return "today";
    }

    @GetMapping("/addProject")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "addProject";
    }

    @PostMapping("/addProject")
    public String addProject(@Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "addProject";
        }
        List<User> users = new ArrayList<>();
        users.add(userService.findById((long)1));
        project.setUsers(users);
        Project saved = projectService.save(project);
        return "redirect:/project/" + saved.getId();
    }

    @RequestMapping("/task/{id}")
    public String task() {
        return "task";
    }

    @RequestMapping("/project/{id}")
    public String project(@PathVariable Long id, Model model) {
        Project project = projectService.findByIdWithTasks(id);
        model.addAttribute("project", project);
        System.out.println(project.getTasks());
        return "project";
    }

    @RequestMapping("/nextSevenDays")
    public String nextWeek() {
        return "nextSevenDays";
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult result) {
        if (result.hasErrors()){
            return "addTask";
        }
        taskService.save(task);
        return "redirect:/project/" + task.getProject().getId();
    }
}
