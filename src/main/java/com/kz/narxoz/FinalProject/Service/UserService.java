package com.kz.narxoz.FinalProject.Service;

import com.kz.narxoz.FinalProject.Entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Users getUserByEmail(String Email);
    Users createUser(Users user);

}
