
package com.example.backend.service;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
 private final StringRedisTemplate r;
 public RedisService(StringRedisTemplate r){this.r=r;}

 public void score(Long id,int v){r.opsForValue().increment("post:"+id+":score",v);}

 public boolean botLimit(Long id){
  Long c=r.opsForValue().increment("post:"+id+":bot");
  return c<=100;
 }

 public boolean cooldown(Long b,Long u){
  String k="cool:"+b+":"+u;
  if(Boolean.TRUE.equals(r.hasKey(k))) return false;
  r.opsForValue().set(k,"1",10,TimeUnit.MINUTES);
  return true;
 }
}
