package com.backend.bybus.auth.model.user;

public enum UserRole {
    ADMIN("ADMIN"),
    OWNER("OWNER"),
    PASSENGER("PASSENGER");

    private String role;
    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
