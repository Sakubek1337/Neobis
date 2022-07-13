package com.example.drinkshop.Controllers;

import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Models.RegistrationInfo;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Service.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    DrinkRepo dr;

    @Autowired
    DatabaseManager dbm;

    RegistrationInfo RI = new RegistrationInfo();

    @GetMapping("/main")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("general/main-page");
        List<Drink> drinks = dr.findAll();
        mav.addObject("products", drinks);
        return mav;
    }

    @GetMapping("/")
    public String redirtomain(){
        return "redirect:main";
    }

    @GetMapping("/admin/add-product")
    public ModelAndView add_page(){
        ModelAndView mav = new ModelAndView("product/product-add");
        Drink new_drink = new Drink();
        mav.addObject("new_product", new_drink);
        return mav;
    }

    @PostMapping("/admin/action/save")
    public String save(@ModelAttribute Drink drink){
        dr.save(drink);
        return "redirect:/main";
    }

    @PostMapping("/admin/action/delete-product/{id}")
    public String delete(@ModelAttribute Drink drink){
        dr.delete(drink);
        return "redirect:/main";
    }

    @GetMapping("/product/{id}")
    public ModelAndView get(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("product/product-page");
        Drink drink = dr.getById(id);
        mav.addObject("product", drink);
        return mav;
    }

    //Will be done in week9
    //will have button in product page that will lead to this page
    @GetMapping("/admin/update-product/{id}")
    public ModelAndView update(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("product/product-update");
        Drink drink = dr.getById(id);
        mav.addObject("product", drink);
        return mav;
    }

    @PostMapping("/admin/action/update-product")
    public String action_update(@ModelAttribute Drink drink){
        dr.save(drink);
        return "redirect:" + drink.getId();
    }

    @GetMapping("/order")
    public ModelAndView show_order_page(){
        return new ModelAndView("general/order-page");
    }

    //Will be updated in week9
    @PostMapping("/order/{id}")
    public String order(@PathVariable Long id){
        return "Drink " + dr.findById(id).get().getName() + " was successfully delivered to your berloga! Enjoy!";
    }

    //Will be done in week10
    @GetMapping("/profile")
    public ModelAndView prof(){
        ModelAndView mav = new ModelAndView("profile/profile-main");
        return mav;
    }

    //This will be a page where you can update attributes of your profile.
    //Controller will get current profile via accessing principle details(username to be precise).
    //Will code in week10
    @GetMapping("/profile/update")
    public ModelAndView upd(){
        ModelAndView mav = new ModelAndView("profile/profile-update");
        return mav;
    }
    //Will be done in week10
    @PostMapping("/profile/update-profile")
    public String perform_update(){
        return "redirect:/profile";
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
        System.out.println("/register POST");
        user.setRole("ROLE_USER");
        if(dbm.checkUser(user.getUsername())){
            RI.setInUse(true);
        }else{
            dbm.addUser(user);
            RI.setInUse(false);
            try {
                request.login(user.getUsername(), user.getPassword());
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        return "redirect:main";
    }

    @GetMapping("/admin")
    public ModelAndView adminMain(){
        return new ModelAndView("admin/admin-main");
    }

}
