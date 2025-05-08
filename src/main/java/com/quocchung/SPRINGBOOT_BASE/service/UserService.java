package com.quocchung.SPRINGBOOT_BASE.service;

import com.quocchung.SPRINGBOOT_BASE.dto.request.UserRequestDTO;
import com.quocchung.SPRINGBOOT_BASE.dto.response.UserDetailResponse;
import java.util.List;

public interface UserService {


    UserDetailResponse getUser(Long userId);

    void addUser(UserRequestDTO userRequestDTO);

    void delete(Long id);

    void UpdateUser(Long id, UserRequestDTO user);

    List<UserDetailResponse> getAllUsers();
}
