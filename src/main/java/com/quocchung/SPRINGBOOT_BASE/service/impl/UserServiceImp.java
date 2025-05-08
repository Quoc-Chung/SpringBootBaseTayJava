package com.quocchung.SPRINGBOOT_BASE.service.impl;

import com.quocchung.SPRINGBOOT_BASE.dto.request.UserRequestDTO;
import com.quocchung.SPRINGBOOT_BASE.dto.response.UserDetailResponse;
import com.quocchung.SPRINGBOOT_BASE.exception.ResourceNotFoundException;
import com.quocchung.SPRINGBOOT_BASE.model.User;
import com.quocchung.SPRINGBOOT_BASE.repository.UserRepository;
import com.quocchung.SPRINGBOOT_BASE.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;

  private final ModelMapper modelMapper;

  @Override
  public UserDetailResponse getUser(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NoSuchElementException("NOT USER ID:  " + userId));

    UserDetailResponse userDetailResponse = new UserDetailResponse();
    modelMapper.map(user, userDetailResponse);
    return userDetailResponse;
  }

  @Override
  public void addUser(UserRequestDTO userRequestDTO) {
      User user = modelMapper.map(userRequestDTO, User.class);
      userRepository.save(user);
  }


  @Override
  public void delete(Long id) {
     userRepository.deleteById(id);
  }



  @Override
  public void UpdateUser(Long id, UserRequestDTO user) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
    User existingUser = optionalUser.get();

    modelMapper.map(user, existingUser);

    userRepository.save(existingUser);
    } else {
      throw new RuntimeException("User not found with id: " + id);
    }
  }

  @Override
  public List<UserDetailResponse> getAllUsers() {
    List<User> users = userRepository.findAll();
    List<UserDetailResponse> userDetailResponses = new ArrayList<>();
    for (User user : users) {
      UserDetailResponse userDetailResponse = new UserDetailResponse();
      modelMapper.map(user, userDetailResponse);
      userDetailResponses.add(userDetailResponse);
    }
    return  userDetailResponses;
  }

}
