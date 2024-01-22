package com.ssudikon.userservice.service.impl;

import com.ssudikon.userservice.entity.User;
import com.ssudikon.userservice.error.UserNotFoundException;
import com.ssudikon.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl() {
        userList = List.of(
                new User(1, "John", "Doe", new Date(), 101),
                new User(2, "Jane", "Doe", new Date(), 102),
                new User(3, "Jack", "Doe", new Date(), 103),
                new User(4, "Jill", "Doe", new Date(), 104),
                new User(5, "Joe", "Doe", new Date(), 105),
                new User(6, "Jen", "Doe", new Date(), 106)

        );
    }
    @Override
    public User getUserDetailsById(Integer userId) throws UserNotFoundException {
        return userList.stream()
                .filter(user -> user.id() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    @Override
    public User getUserByDeptId(Integer deptId) throws UserNotFoundException {
        return userList.stream()
                .filter(user -> user.deptId() == deptId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with dept id: " + deptId));
    }
}
