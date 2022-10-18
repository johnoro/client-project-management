package com.johnoro.cpm.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    @ElementCollection
    @CollectionTable(name = "projects", joinColumns = @JoinColumn(name = "client_id"))
    private List<Project> projects;
}
