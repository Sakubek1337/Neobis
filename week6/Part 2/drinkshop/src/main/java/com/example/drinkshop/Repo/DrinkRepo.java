package com.example.drinkshop.Repo;

import com.example.drinkshop.Models.Entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Long> {
}
