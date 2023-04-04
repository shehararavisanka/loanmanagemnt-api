package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usersRepository  extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
