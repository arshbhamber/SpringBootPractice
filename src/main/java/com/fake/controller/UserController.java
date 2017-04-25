package com.fake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fake.entity.User;
import com.fake.entity.Message;
import com.fake.repository.UserRepository;
import com.fake.repository.MessageRepository;


@Controller
@RequestMapping(path="/user")
public class UserController{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MessageRepository messageRepository;

  @GetMapping(path="/add")
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";

  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers(){

    return userRepository.findAll();

  }

  @GetMapping(path="/sendMessage")
  public void sendMessage(@RequestParam String senderId, @RequestParam String receiverId, @RequestParam String content){

    Message message = new Message();
    message.setContent(content);
    message.setTo(receiverId);
    message.setFrom(senderId);

    messageRepository.save(message);


  }


}
