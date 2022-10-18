package com.johnoro.cpm.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "projects")
@Data @NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long clientId;
    private String name;
    private String description;
    private String status;
    private String notes;
    private String startDate;
    private String endDate;
    private String manager;
    private String team;
}