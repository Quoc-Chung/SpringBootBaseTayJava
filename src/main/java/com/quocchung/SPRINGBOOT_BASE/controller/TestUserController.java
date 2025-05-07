package com.quocchung.SPRINGBOOT_BASE.controller;
import com.quocchung.SPRINGBOOT_BASE.dto.request.NguoiDungDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestUserController {
  @PostMapping("/status")
  public String StatusUser(@Valid  @RequestBody NguoiDungDTO status) {
    return "OK";
  }
}
