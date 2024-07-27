package com.springproject.userdept.Repositories;

import com.springproject.userdept.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
