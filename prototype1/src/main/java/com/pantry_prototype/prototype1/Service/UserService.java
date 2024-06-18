package com.pantry_prototype.prototype1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pantry_prototype.prototype1.Repository.ItemRepository;
import com.pantry_prototype.prototype1.Repository.UserRepository;
import com.pantry_prototype.prototype1.model.Items;
import com.pantry_prototype.prototype1.model.Users;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public List<Items> getItems(){
        return itemRepository.findAll();
    }
    
    public Items postItems(Items Item){
        return itemRepository.save(Item);   
    }

    public void deleteItem(Integer id){
        itemRepository.deleteById(id);
    }

    public Boolean authUser(String name, String password){
        List<Users> user = userRepository.findAll();
        for(Users u: user){
            if(u.getName().equals(name)){
                if(u.getPassword().equals(password)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
