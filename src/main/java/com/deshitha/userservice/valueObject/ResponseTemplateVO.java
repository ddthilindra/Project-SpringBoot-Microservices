package com.deshitha.userservice.valueObject;

import com.deshitha.userservice.entity.Users;
import com.deshitha.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Users users;
    private Department department;

    public void setUser(Users users) {
    }
}
