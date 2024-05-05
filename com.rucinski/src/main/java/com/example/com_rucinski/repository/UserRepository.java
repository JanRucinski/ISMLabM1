package com.murad.sh.carbootsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.murad.sh.carbootsale.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
