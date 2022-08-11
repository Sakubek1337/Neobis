package com.example.drinkshop.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationInfo {

    private boolean isInUse;

    public RegistrationInfo(){
        isInUse = false;
    }

}