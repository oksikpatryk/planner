package com.planner.planner.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotEmpty
    private String name;
    private LocalDateTime closeDate;
//    private List<String> emails = new ArrayList<>();
    @NotNull
    @Max(4)
    @Min(1)
    private Integer priority;
    @NotNull
    @ManyToOne
    private Project project;
}
