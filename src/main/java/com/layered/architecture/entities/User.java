package com.layered.architecture.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    Integer id;
    String name;
    String email;
    Integer age;
    LocalDateTime time;
    String feedback;
}
