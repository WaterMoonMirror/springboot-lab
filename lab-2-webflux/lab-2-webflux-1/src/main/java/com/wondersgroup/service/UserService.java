package com.wondersgroup.service;// UserService.java

import com.wondersgroup.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }

}