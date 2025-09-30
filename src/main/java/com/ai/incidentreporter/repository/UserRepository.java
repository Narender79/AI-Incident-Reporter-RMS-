package com.ai.incidentreporter.repository;

import com.ai.incidentreporter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);

}

