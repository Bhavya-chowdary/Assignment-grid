
package com.example.backend.entity;
import jakarta.persistence.*;

@Entity
public class Bot {
 @Id @GeneratedValue
 private Long id;
 private String name;
 private String personaDescription;
}
