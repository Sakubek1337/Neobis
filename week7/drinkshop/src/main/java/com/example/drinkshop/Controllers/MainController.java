package com.example.drinkshop.Controllers;

import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    DrinkRepo dr;

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

    @GetMapping("/product/add")
    public ModelAndView add_page(){
        ModelAndView mav = new ModelAndView("product/product-add");
        Drink new_drink = new Drink();
        mav.addObject("new_product", new_drink);
        return mav;
    }

    @PostMapping("/product/delete")
    public String delete(@ModelAttribute Drink drink){
        dr.delete(drink);
        return "redirect:main";
    }

    @GetMapping("/product/{id}")
    public ModelAndView get(@ModelAttribute Drink drink){
        ModelAndView mav = new ModelAndView("product/product-page");
        mav.addObject("product", drink);
        return mav;
    }

    //Will be done in week8
    //will have button in product page that will lead to this page
    @GetMapping("/product/{id}/update")
    public ModelAndView update(@ModelAttribute Drink drink){
        ModelAndView mav = new ModelAndView("product/product-update");
        mav.addObject("product", drink);
        return mav;
    }

    @PostMapping("/product/update-product")
    public String action_update(@ModelAttribute Drink drink){
        dr.save(drink);
        return "redirect:product/" + drink.getId();
    }

    @GetMapping("/order")
    public ModelAndView show_order_page(){
        return new ModelAndView("general/order-page");
    }

    //Will be updated in week8
    @PostMapping("/order/{id}")
    public String order(@PathVariable Long id){
        return "Drink " + dr.findById(id).get().getName() + " was successfully delivered to your berloga! Enjoy!";
    }

    //Will be done in week8
    @GetMapping("/profile")
    public ModelAndView prof(){
        ModelAndView mav = new ModelAndView("profile/profile-main");
        return mav;
    }

    //This will be a page where you can update attributes of your profile.
    //Controller will get current profile via accessing principle details(username to be precise).
    //Will code in week8
    @GetMapping("/profile/update")
    public ModelAndView upd(){
        ModelAndView mav = new ModelAndView("profile/profile-update");
        return mav;
    }
    //Will be done in week8
    @PostMapping("/profile/update-profile")
    public String perform_update(){
        return "redirect:profile";
    }

    @GetMapping("/login")
    public String show_login_page(){
        return "Coming in week 8...";
    }

    @PostMapping("/register")
    public String register(){
        return "Coming in week 8...";
    }

}
