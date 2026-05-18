package com.example.demo.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByNameIgnoreCase(String name, Pageable pageable);
}
