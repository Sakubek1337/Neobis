package com.example.drinkshop.Controllers;

import com.example.drinkshop.Entity.Drink;
import com.example.drinkshop.Repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DrinkRepo dr;

    @GetMapping(value="/main", produces = MediaType.TEXT_PLAIN_VALUE)
    public String main(){
        StringBuilder sb = new StringBuilder();
        List<Drink> drinks = dr.findAll();
        for(Drink d : drinks){
            sb.append(d.getId()).append("-").append(d.getName())
                    .append("-").append(d.getPrice_in_soms())
                    .append("\n");
        }
        return sb.toString();
    }

    @GetMapping("/")
    public String redirtomain(){
        return "redirect:main";
    }

    @PostMapping("/addDrink")
    public String newDonut(@RequestBody Drink newDrink){
        System.out.println(newDrink.getName());
        dr.save(newDrink);
        return "New drink was successfully added to the database!";
    }

    @PostMapping("/deleteDrink/{id}")
    public String delete(@PathVariable Long id){
        dr.deleteById(id);
        return "Drink was successfully deleted from the database!";
    }

    @GetMapping("/showDrink/{id}")
    public Drink get(@PathVariable Long id){
        return dr.findById(id).orElse(null);
    }

    @PatchMapping("/updateDrink/{id}")
    public String update(@PathVariable Long id, @RequestBody Drink drink){
        drink.setId(id);
        dr.save(drink);
        return "Drink was successfully updated!";
    }

    @PostMapping("/order/{id}")
    public String order(@PathVariable Long id){
        return "Drink " + dr.findById(id).get().getName() + " was succesfully delivered to your berloga! Enjoy!";
    }
}
