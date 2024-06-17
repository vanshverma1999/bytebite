package com.bytebite.user_service.repository;

import com.bytebite.user_service.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);

    List<UserDetails> findByNameLike(String name);
}