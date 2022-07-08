package com.example.drinkshop.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="drinks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int net_weight;

    private int price_in_soms;
}
