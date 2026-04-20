
package com.example.backend.controller;
import com.example.backend.entity.*;
import com.example.backend.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
 private final PostService s;
 public PostController(PostService s){this.s=s;}

 @PostMapping
 public Post create(@RequestBody Post p){return s.create(p);}

 @PostMapping("/{id}/comments")
 public Comment c(@PathVariable Long id,@RequestBody Comment cm){return s.comment(id,cm);}

 @PostMapping("/{id}/like")
 public String l(@PathVariable Long id){s.like(id);return "ok";}
}
