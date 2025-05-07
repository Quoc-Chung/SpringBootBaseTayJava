package com.quocchung.SPRINGBOOT_BASE.controller;

import com.quocchung.SPRINGBOOT_BASE.service.BaseRedisService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

  private final BaseRedisService<String,String,Integer> baseRedisService;
  public RedisController(BaseRedisService baseRedisService) {
    this.baseRedisService = baseRedisService;
  }

  @PostMapping("/add")
  public void saveRedis() {
     baseRedisService.set("namesv",123);
  }

}
