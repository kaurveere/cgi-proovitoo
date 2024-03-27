package com.cinema.backend.repository;

import com.cinema.backend.entity.Film;
import com.cinema.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
