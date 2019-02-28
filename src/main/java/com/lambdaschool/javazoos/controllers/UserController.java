package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.User;
import com.lambdaschool.javazoos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUser()
    {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id)
    {
        var foundUser = userRepo.findById(id);
        if (foundUser.isPresent()) {
            userRepo.deleteById(id);

            return "{" + "\"id\":" + foundUser.get().getId() +
                    ",\"usename\":" + "\"" + foundUser.get().getUsername() + "\"" +
                    ",\"role\":" + foundUser.get().getAuthority() + "}";
        } else {
            return null;
        }
    }

}