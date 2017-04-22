package com.fake.repository;


import org.springframework.data.repository.CrudRepository;

import com.fake.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{


}
