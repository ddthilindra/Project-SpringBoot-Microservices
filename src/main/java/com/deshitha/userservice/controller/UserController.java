package com.deshitha.userservice.controller;

import com.deshitha.userservice.entity.Users;
import com.deshitha.userservice.service.UserService;
import com.deshitha.userservice.valueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        log.info("Inside saveUser of UserController");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+user);
        return  userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
