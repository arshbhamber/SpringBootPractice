package com.fake.repository;

import org.springframework.data.repository.CrudRepository;

import com.fake.entity.Message;

public interface MessageRepository extends CrudRepository<Message,Long>{


}
