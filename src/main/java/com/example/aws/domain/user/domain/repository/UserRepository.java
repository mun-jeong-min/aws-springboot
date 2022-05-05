package com.example.aws.domain.user.domain.repository;

import com.example.aws.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
