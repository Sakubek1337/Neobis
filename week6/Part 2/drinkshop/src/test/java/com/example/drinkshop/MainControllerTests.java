package com.example.drinkshop;

import com.example.drinkshop.Controllers.MainController;
import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Repo.UserRepo;
import com.example.drinkshop.Service.DatabaseManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class MainControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserRepo userRepo;
    @MockBean
    DrinkRepo drinkRepo;
    @MockBean
    DatabaseManager dbm;

    Drink drink1 = new Drink(1L, "coke", 123, 321, "url");
    Drink drink2 = new Drink(2L, "pepsi", 123, 321, "url");
    Drink drink3 = new Drink(3L, "coffee", 123, 321, "url");



    @Test
    public void getProducts_success() throws Exception {
        List<Drink> drinks = Arrays.asList(drink1, drink2, drink3);
        Mockito.when(dbm.getDrinks()).thenReturn(drinks);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("pepsi"));
    }

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void getProductById_success() throws Exception {
        Mockito.when(dbm.getDrinkById(1L)).thenReturn(drink1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("coke"));
    }
}
