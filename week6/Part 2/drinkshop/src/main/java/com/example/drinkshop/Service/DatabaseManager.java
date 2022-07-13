package com.example.drinkshop.Service;

import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseManager {

    @Autowired
    UserRepo ur;

    @Autowired
    DrinkRepo dr;

    public void addUser(User user){
        ur.save(user);
    }

    public boolean checkUser(String username){
        Optional<User> user = ur.findByUsername(username);
        return user.isPresent();
    }
}
