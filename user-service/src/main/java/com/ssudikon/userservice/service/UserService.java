package com.ssudikon.userservice.service;

import com.ssudikon.userservice.entity.User;
import com.ssudikon.userservice.error.UserNotFoundException;

public interface UserService {
    User getUserDetailsById(Integer userId) throws UserNotFoundException;

    User getUserByDeptId(Integer deptId) throws UserNotFoundException;
}
