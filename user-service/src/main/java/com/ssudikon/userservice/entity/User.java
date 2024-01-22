package com.ssudikon.userservice.entity;

import java.util.Date;

public record User(int id, String firstName, String lastName, Date birthDate, int deptId) {
}
