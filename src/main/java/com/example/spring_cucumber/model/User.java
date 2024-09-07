package com.example.spring_cucumber.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_t")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}
