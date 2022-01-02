package io.github.starfreck.flixzoneapis.App.Controllers;

import io.github.starfreck.flixzoneapis.App.Models.Auth.User;
import io.github.starfreck.flixzoneapis.App.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Set<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody User user){
        user.setId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

    // Telegram User Specific operations

    @GetMapping("/telegram/{id}")
    public User getTelegramUser(@PathVariable("id") String telegramId){
        return userService.getTelegramUser(telegramId);
    }

    @PutMapping("/telegram/{id}")
    public void updateTelegramUser(@PathVariable("id") String telegramId, @RequestBody User user){
        user.setTelegramId(telegramId);
        userService.updateTelegramUser(user);
    }
}
