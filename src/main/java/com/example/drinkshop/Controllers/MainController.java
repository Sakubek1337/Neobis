package com.example.drinkshop.Controllers;

import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Models.RegistrationInfo;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Repo.UserRepo;
import com.example.drinkshop.Security.MyUserService;
import com.example.drinkshop.Service.DatabaseManager;
import com.example.drinkshop.Util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    DatabaseManager dbm;

    @Autowired
    DrinkRepo dr;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MyUserService myUserService;

    @Autowired
    JwtUtil jwtUtil;

    AuthenticationManager authenticationManager;

    RegistrationInfo RI = new RegistrationInfo();

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("username") String username,
                                       @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username
                    , password));
            if (auth.isAuthenticated()) {
                UserDetails userDetails = myUserService.loadUserByUsername(username);
                String token = jwtUtil.generateToken(userDetails);
                responseMap.put("error", false);
                responseMap.put("message", "Logged In");
                responseMap.put("token", token);
                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put("error", true);
                responseMap.put("message", "Invalid Credentials");
                return ResponseEntity.status(401).body(responseMap);
            }
        } catch (DisabledException e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "User is disabled");
            return ResponseEntity.status(500).body(responseMap);
        } catch (BadCredentialsException e) {
            responseMap.put("error", true);
            responseMap.put("message", "Invalid Credentials");
            return ResponseEntity.status(401).body(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "Something went wrong");
            return ResponseEntity.status(500).body(responseMap);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestParam("username") String userName,
                                      @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        User user = new User();
        user.setPassword(password);
        user.setRole("ROLE_USER");
        user.setUsername(userName);
        userRepo.save(user);
        UserDetails userDetails = myUserService.loadUserByUsername(userName);
        String token = jwtUtil.generateToken(userDetails);
        responseMap.put("error", false);
        responseMap.put("username", userName);
        responseMap.put("message", "Account created successfully");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/getUser")
    public Map<String, Object> getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", authentication.getName());
        userMap.put("error", false);
        return userMap;
    }

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


    @Operation(summary = "Get the list of administrators")
    @GetMapping("/admins")
    public String adminMain(){
        return dbm.getAdmins();
    }

}
