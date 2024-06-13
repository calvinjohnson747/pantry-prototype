package com.pantry_prototype.prototype1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pantry_prototype.prototype1.Service.UserService;
import com.pantry_prototype.prototype1.model.Items;
import com.pantry_prototype.prototype1.model.Users;

import java.util.*;

@RestController
@RequestMapping(path="/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<Users> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/getitems")
    public List<Items> getItems(){
        return userService.getItems();
    }

    @PostMapping("/post")
    public ResponseEntity<Items> postItems(@RequestBody Items items){
        Items InsertedItem = userService.postItems(items);
        return ResponseEntity.ok().body(InsertedItem);
    }
}
