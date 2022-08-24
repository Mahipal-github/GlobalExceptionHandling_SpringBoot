package com.dailycodebuffer.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.userservice.Entity.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Long>{

	Person findByUserId(Long userId);

}
