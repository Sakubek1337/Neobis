package com.example.drinkshop.Repo;

import com.example.drinkshop.Models.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM users WHERE role=:role", nativeQuery = true)
    List<User> findByRole(@Param("role") String role);
}
