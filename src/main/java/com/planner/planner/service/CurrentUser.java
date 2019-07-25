package com.planner.planner.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private final com.planner.planner.entity.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.planner.planner.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public com.planner.planner.entity.User getUser() {return user;}
}
