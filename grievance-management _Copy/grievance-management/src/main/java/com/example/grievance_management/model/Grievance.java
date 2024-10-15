package com.example.grievance_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceId;

    private String grievanceType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
