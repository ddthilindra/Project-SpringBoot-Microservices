package com.deshitha.userservice.service;

import com.deshitha.userservice.entity.Users;
import com.deshitha.userservice.repository.UserRepository;
import com.deshitha.userservice.valueObject.Department;
import com.deshitha.userservice.valueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public Users saveUser(Users user) {
        log.info("Inside saveUser method of UserService");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+user);
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo= new ResponseTemplateVO();
        Users users=userRepository.findByUserId(userId);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+users);

        // calling department microservice and get department id
        Department department=restTemplate.getForObject("http://localhost:9005/departments/"+users.getDepartmentId(),Department.class);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+department);
        vo.setUsers(users);
        vo.setDepartment(department);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+vo);
        return vo;
    }
}
