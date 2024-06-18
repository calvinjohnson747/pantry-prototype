package com.pantry_prototype.prototype1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public ResponseEntity<String> authenticateUser(@RequestBody Users User){
        String username = User.getName();
        String password = User.getPassword();
        System.out.println("username: "+username+"\npassword: "+password);
        Boolean auth = userService.authUser(username,password);
        if(auth){
            return ResponseEntity.ok("true");
        }
    
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("false");
        }
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") Integer id){
        try{
            userService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
