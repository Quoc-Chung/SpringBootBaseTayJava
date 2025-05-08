package com.quocchung.SPRINGBOOT_BASE.controller;
import com.quocchung.SPRINGBOOT_BASE.dto.request.UserRequestDTO;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ErrorResponse;
import com.quocchung.SPRINGBOOT_BASE.dto.response.GeneralResponse;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseData;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseError;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseFactory;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseStatus;
import com.quocchung.SPRINGBOOT_BASE.dto.response.UserDetailResponse;
import com.quocchung.SPRINGBOOT_BASE.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getUser(@PathVariable Long id){
    return  ResponseFactory.success(userService.getUser(id));
  }

  @GetMapping()
  public ResponseEntity<GeneralResponse<List<UserDetailResponse>>> getUser(){
    return ResponseFactory.success(userService.getAllUsers());

  }


  @PostMapping()
  public ResponseData<UserRequestDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
       userService.addUser(userRequestDTO);
       return new ResponseData<>(HttpStatus.CREATED.value(), "thanh cong roi nha", userRequestDTO);
  }


  @PutMapping("/users/{userId}")
  public void updateUser(@Min(1) @PathVariable Long userId, @RequestBody UserRequestDTO user) {
     userService.UpdateUser(userId, user);
  }

  @PatchMapping("/users/{id}")
  public ResponseEntity<String> updateUserPartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok("Đã cập nhật user có ID: " + id);
  }

  @DeleteMapping("users/{userId}")
  public String deleteUser(@PathVariable int userId) {
    return " delete success : " + userId;
  }
}


