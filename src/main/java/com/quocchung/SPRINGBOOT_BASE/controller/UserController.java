package com.quocchung.SPRINGBOOT_BASE.controller;
import com.quocchung.SPRINGBOOT_BASE.dto.request.UserRequestDTO;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseSuccess;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{


  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public String getUser(){
    return "success";
  }

  @PostMapping("/")
  public String addUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
     return "success";
  }



  @PutMapping("/users/{userId}")
  public ResponseSuccess updateUser(@Min(1) @PathVariable int userId, @RequestBody UserRequestDTO user) {
    return new ResponseSuccess(HttpStatus.ACCEPTED,"User updated success");
  }


  /**
   * Cập nhật một phần dữ liệu (partial update)
   * @param id chỗ cần update
   * @param updates phần dữ liệu mới cần update
   * @return trạng thái update dữ liệu một phần có thành công không
   */
  @PatchMapping("/users/{id}")
  public ResponseEntity<String> updateUserPartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok("Đã cập nhật user có ID: " + id);
  }




  @DeleteMapping("users/{userId}")
  public String deleteUser(@PathVariable int userId) {
    return " delete success : " + userId;
  }
}


