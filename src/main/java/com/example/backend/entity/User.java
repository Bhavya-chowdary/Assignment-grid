
package com.example.backend.entity;
import jakarta.persistence.*;

@Entity
public class User {
 @Id @GeneratedValue
 private Long id;
 private String username;
 private boolean isPremium;
}
