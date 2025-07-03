package com.trackease.timesheet.Auth;

import com.trackease.timesheet.Model.UserRole;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private UserRole role;


}
