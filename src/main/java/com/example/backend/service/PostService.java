
package com.example.backend.service;
import com.example.backend.entity.*;
import com.example.backend.repository.*;
import org.springframework.stereotype.Service;

@Service
public class PostService {
 private final PostRepository p;
 private final CommentRepository c;
 private final RedisService r;

 public PostService(PostRepository p,CommentRepository c,RedisService r){
  this.p=p;this.c=c;this.r=r;
 }

 public Post create(Post post){return p.save(post);}

 public Comment comment(Long id,Comment cm){
  if(cm.getDepthLevel()>20) throw new RuntimeException();
  if(!r.botLimit(id)) throw new RuntimeException();
  r.score(id,50);
  return c.save(cm);
 }

 public void like(Long id){r.score(id,20);}
}
