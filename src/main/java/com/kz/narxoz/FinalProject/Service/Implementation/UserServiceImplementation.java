package com.kz.narxoz.FinalProject.Service.Implementation;

import com.kz.narxoz.FinalProject.Entity.Roles;
import com.kz.narxoz.FinalProject.Entity.Users;
import com.kz.narxoz.FinalProject.Repository.RoleRepository;
import com.kz.narxoz.FinalProject.Repository.UserRepository;
import com.kz.narxoz.FinalProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Users myUser = userRepository.findByEmail(s);
        if(myUser!=null){

            User secUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
            return secUser;

        }

        throw new UsernameNotFoundException("User Name Not Found");
    }

    @Override
    public Users getUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public Users createUser(Users user) {
        Users checkUser = userRepository.findByEmail(user.getEmail());
        if(checkUser==null){
            Roles role = roleRepository.findByRole("ROLE_USER");
            if(role!=null){
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        }
        return null;
    }
}
