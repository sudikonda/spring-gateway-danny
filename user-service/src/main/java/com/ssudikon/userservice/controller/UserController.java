package com.ssudikon.userservice.controller;

import com.ssudikon.userservice.entity.User;
import com.ssudikon.userservice.entity.UserResponse;
import com.ssudikon.userservice.error.UserError;
import com.ssudikon.userservice.error.UserNotFoundException;
import com.ssudikon.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getUserDetailsById", produces = "application/json")
    public ResponseEntity<UserResponse> getUserDetailsById(@RequestParam Integer userId) {
        UserResponse userResponse;
        try {
            User userDetailsById = userService.getUserDetailsById(userId);
            userResponse = new UserResponse(userDetailsById, null);
        } catch (UserNotFoundException e) {
            UserError userError = new UserError(e.getMessage());
            userResponse = new UserResponse(null, userError);
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping(value = "/getUserByDeptId", produces = "application/json")
    public ResponseEntity<UserResponse> getUserByDeptId(@RequestParam Integer deptId) {
        UserResponse userResponse;
        try {
            User userByDeptId = userService.getUserByDeptId(deptId);
            userResponse = new UserResponse(userByDeptId, null);
        } catch (UserNotFoundException e) {
            UserError userError = new UserError(e.getMessage());
            userResponse = new UserResponse(null, userError);
        }
        return ResponseEntity.ok(userResponse);
    }
}
