package com.trackease.timesheet.Auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
