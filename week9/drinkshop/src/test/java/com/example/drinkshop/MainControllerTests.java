package com.example.drinkshop;

import com.example.drinkshop.Controllers.MainController;
import com.example.drinkshop.Models.Entity.Drink;
import com.example.drinkshop.Models.Entity.User;
import com.example.drinkshop.Repo.DrinkRepo;
import com.example.drinkshop.Repo.UserRepo;
import com.example.drinkshop.Service.DatabaseManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class MainControllerTests {



    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    UserRepo userRepo;
    @MockBean
    DrinkRepo drinkRepo;
    @MockBean
    DatabaseManager dbm;

    Drink drink1 = new Drink(1L, "coke", 123, 321, "url");
    Drink drink2 = new Drink(2L, "pepsi", 123, 321, "url");
    Drink drink3 = new Drink(3L, "coffee", 123, 321, "url");

    User user1 = User.builder()
            .id(1L)
            .username("user1")
            .password("password")
            .role("ROLE_USER")
            .build();
    User user2 = User.builder()
            .id(2L)
            .username("user2")
            .password("password")
            .role("ROLE_USER")
            .build();
    User user3 = User.builder()
            .id(3L)
            .username("admin1")
            .password("password")
            .role("ROLE_ADMIN")
            .build();
    User user4 = User.builder()
            .id(4L)
            .username("admin2")
            .password("password")
            .role("ROLE_ADMIN")
            .build();

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

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void createProduct_success() throws Exception {
        Drink record = Drink.builder()
                .id(99L)
                .name("Sprite")
                .net_weight(47)
                .price_in_soms(199)
                .pict_url("never gonna give you up")
                .build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/admin/add-product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("New product was successfully added to database!"));
    }

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void createProduct_fail() throws Exception {
        Drink record = Drink.builder()
                .id(100L)
                //.name("Shoro") |- Testing without name
                .net_weight(88)
                .price_in_soms(250)
                .pict_url("url")
                .build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/admin/add-product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid credentials!"));
    }

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void createUser_success() throws Exception {
        User record = User.builder()
                .id(1337L)
                .username("Kevin Durant")
                .password("7777777")
                .role("ROLE_USER")
                .build();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/admin/add-user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("New user was successfully added!"));
    }

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void createUser_fail() throws Exception {
        User record = User.builder()
                .id(1339L)
                .username("Adam Traore")
                //testing without password
                .role("ROLE_USER")
                .build();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/admin/add-user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid credentials!"));
    }

    @Test
    @WithMockUser(username = "sss", password = "123", roles = {"ADMIN", "USER"})
    public void getUsers_success() throws Exception {
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        Mockito.when(dbm.getUsers()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/admin/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].username").value("admin1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
    }
}
