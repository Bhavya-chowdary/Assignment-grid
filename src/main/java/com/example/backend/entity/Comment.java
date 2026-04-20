
package com.example.backend.entity;
import jakarta.persistence.*;
import java.time.*;

@Entity
public class Comment {
 @Id @GeneratedValue
 private Long id;
 private Long postId;
 private Long authorId;
 private String content;
 private int depthLevel;
 private LocalDateTime createdAt = LocalDateTime.now();
}
