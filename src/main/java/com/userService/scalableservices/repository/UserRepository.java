package com.userService.scalableservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userService.scalableservices.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
	
 	@Query("select u from Users u where id=:userId")
    Users findByUserId(@Param("userId") int userId);

}
