package com.example.drinkshop.Security;

import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(user.get().getRole()));
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), authorityList);
    }
}
