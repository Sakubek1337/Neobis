package com.example.drinkshop.Service;

import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseManager {

    @Autowired
    UserRepo ur;

    @Autowired
    DrinkRepo dr;

    public void saveUser(User user){
        ur.save(user);
    }

    public void deleteUser(User user){
        ur.delete(user);
    }

    public User getUserById(Long id){
        return ur.findById(id).get();
    }

    public List<User> getUsers(){
        return ur.findAll();
    }

    public boolean checkUser(String username){
        Optional<User> user = ur.findByUsername(username);
        return user.isPresent();
    }

    public void saveDrink(Drink drink){
        dr.save(drink);
    }

    public void deleteDrink(Drink drink){
        dr.delete(drink);
    }

    public Drink getDrinkById(Long id){
        return dr.findById(id).get();
    }

    public List<Drink> getDrinks(){
        return dr.findAll();
    }

    public String getAdmins(){
        List<User> admins = ur.findByRole("ROLE_ADMIN");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < admins.size(); i++){
            User admin = admins.get(i);
            sb.append(i + 1).append(" - ").append(admin.getUsername()).append("\n");
        }
        return sb.toString().trim();
    }
}
