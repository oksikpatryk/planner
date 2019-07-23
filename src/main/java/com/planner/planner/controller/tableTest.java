package com.planner.planner.controller;

import com.planner.planner.entity.Project;
import com.planner.planner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class tableTest {
    private ProjectService projectService;

    @Autowired
    public tableTest(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ModelAttribute("projects")
    public List<Project> projectList() {
        return projectService.findAll();
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
        Project saved = projectService.save(project);
        return "redirect:/project/" + saved.getId();
    }

    @RequestMapping("/taskDetails")
    public String taskDetails() {
        return "taskDetails";
    }

    @RequestMapping("/project/{id}")
    public String project(@PathVariable Long id, Model model) {
        model.addAttribute("project", id);
        return "project";
    }

    @RequestMapping("/nextSevenDays")
    public String nextWeek() {
        return "nextSevenDays";
    }

    @RequestMapping("/addTask")
    public String addTask() {
        return "addTask";
    }
}
