package com.quocchung.SPRINGBOOT_BASE.controller;
import com.quocchung.SPRINGBOOT_BASE.dto.request.UserRequestDTO;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseData;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseError;
import com.quocchung.SPRINGBOOT_BASE.dto.response.ResponseSuccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  @Operation(
      summary = "summary",
      description = "description",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "User added successfully",
              content = @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  examples = @ExampleObject(
                      name = "ex name",
                      summary = "ex summary",
                      value = """
          {
            "status": 201,
            "message": "User added successfully",
            "data": 1
          }
          """
                  )
              )
          )
      }
  )

  @PostMapping("/")
  //@ResponseStatus(HttpStatus.CREATED)
  /*- Ví dụ hiện tại mình muốn trả về giá trị id user là  1 - */
  public ResponseSuccess addUser( @Valid  @RequestBody UserRequestDTO user) {

    //return 1;
    return new ResponseSuccess(HttpStatus.CREATED, "User add success fully", 1);
  }

  @PostMapping("/them1")
  public ResponseData<?> themUser( @Valid  @RequestBody UserRequestDTO user) {

    return new ResponseData<>(HttpStatus.CREATED.value(), "User add success fully", 1);
  }

  @PostMapping("/them")
  public ResponseData<?> thmNguoiDung( @Valid  @RequestBody UserRequestDTO user) {

     return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Can not create user");
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public String getUser(){
    return "Quoc Chung đã lấy dữ liệu trả về. ";
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


