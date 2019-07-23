package com.planner.planner.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty(message = "Musisz podać nazwę projektu.")
    private String name;
//    @NotEmpty
//    @ManyToMany
//    private List<User> users = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
