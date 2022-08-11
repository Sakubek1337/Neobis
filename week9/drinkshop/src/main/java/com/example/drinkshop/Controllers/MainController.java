package com.example.drinkshop.Controllers;

import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Models.RegistrationInfo;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Service.DatabaseManager;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    DatabaseManager dbm;

    @Autowired
    DrinkRepo dr;

    RegistrationInfo RI = new RegistrationInfo();

    @Operation(summary = "Get the list of all products")
    @GetMapping("/products")
    public List<Drink> main(){
        return dbm.getDrinks();
    }

    @Operation(summary = "Get the list of all users")
    @GetMapping("/admin/users")
    public List<User> getUsers(){
        return dbm.getUsers();
    }

    @Operation(summary = "Add a new user")
    @PostMapping("/admin/add-user")
    public String addUser(@RequestBody User user){
        if(user.getPassword() == null || user.getUsername() == null ||
                (user.getUsername().length() * user.getPassword().length()) == 0){
            return "Invalid credentials!";
        }else{
            dbm.saveUser(user);
            return "New user was successfully added!";
        }
    }

    @Operation(summary = "Add a new product")
    @PostMapping("/admin/add-product")
    public String add(@RequestBody Drink drink){
        if(drink.getName() == null ||
                drink.getName().length() * drink.getNet_weight() * drink.getPrice_in_soms() == 0){
            return "Invalid credentials!";
        }else{
            dbm.saveDrink(drink);
            return "New product was successfully added to database!";
        }
    }

    @Operation(summary = "Delete a product by its ID")
    @DeleteMapping("/admin/delete-product/{id}")
    public Drink delete(@PathVariable Long id){
        Drink drink = dbm.getDrinkById(id);
        dbm.deleteDrink(drink);
        return drink;
    }

    @Operation(summary = "Delete a user by its ID")
    @DeleteMapping("/admin/delete-user/{id}")
    public User deleteUser(@PathVariable Long id){
        User user = dbm.getUserById(id);
        dbm.deleteUser(user);
        return user;
    }

    @Operation(summary = "Get a product by its ID")
    @GetMapping("/product/{id}")
    public Drink get(@PathVariable Long id){
        return dbm.getDrinkById(id);
    }

    @Operation(summary = "Update a product by its ID")
    @PostMapping("/admin/update-product/{id}")
    public String action_update(@RequestBody Drink drink){
        dbm.saveDrink(drink);
        return "Product was successfully updated!";
    }

    @Operation(summary = "Order a product by ID")
    @PostMapping("/order/{id}")
    public String order(@PathVariable Long id){
        return "Drink " + dbm.getDrinkById(id).getName() + " was successfully delivered to your berloga! Enjoy!";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("general/login");
        User user = new User();
        mav.addObject("register", RI);
        mav.addObject("new_user", user);
        return mav;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpServletRequest request){
        user.setRole("ROLE_USER");
        if(dbm.checkUser(user.getUsername())){
            RI.setInUse(true);
            return "Username is already in use, go back to login/reg page!";
        }else{
            dbm.saveUser(user);
            RI.setInUse(false);
            try {
                request.login(user.getUsername(), user.getPassword());
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return "SUCCESS!";
        }

    }

    @Operation(summary = "Get the list of administrators")
    @GetMapping("/admins")
    public String adminMain(){
        return dbm.getAdmins();
    }

}
