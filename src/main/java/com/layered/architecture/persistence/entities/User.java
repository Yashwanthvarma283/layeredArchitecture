package com.layered.architecture.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "uuid")
    UUID uuid;

    @Column(name = "name", length = 255)
    String name;
    @Column(name = "email", length = 255)
    String email;
    @Column(name = "mobile", length = 255)
    String mobile;
    @Column(name = "birth_date")
    LocalDate birthDate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    GenderDb gender;

    @CreationTimestamp
    @Column(name = "created_on")
    Instant createdOn;
    @UpdateTimestamp
    @Column(name = "updated_on")
    Instant updatedOn;
}
