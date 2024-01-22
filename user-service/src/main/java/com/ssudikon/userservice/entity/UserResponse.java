package com.ssudikon.userservice.entity;

import com.ssudikon.userservice.error.UserError;

public record UserResponse(User user, UserError userError) {
}
