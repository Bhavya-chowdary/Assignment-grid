
package com.example.backend.entity;
import jakarta.persistence.*;
import java.time.*;

@Entity
public class Post {
 @Id @GeneratedValue
 private Long id;
 private Long authorId;
 private String content;
 private LocalDateTime createdAt = LocalDateTime.now();
}
