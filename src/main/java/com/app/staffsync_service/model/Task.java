package com.app.staffsync_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.app.staffsync_service.model.enums.StateTask;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String qualification;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StateTask state;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    
    @CreatedDate
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
