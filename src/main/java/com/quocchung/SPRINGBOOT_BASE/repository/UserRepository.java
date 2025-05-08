package com.quocchung.SPRINGBOOT_BASE.repository;

import com.quocchung.SPRINGBOOT_BASE.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

  @Query(value = "select r from Role r inner join UserHasRole ur on r.id = ur.user.id where ur.id = :userId")
  List<User> findAllRolesByUserId(Long userId);
}
