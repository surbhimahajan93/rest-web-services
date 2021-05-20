package com.myproject.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Eve", new Date()));
        users.add(new User(3,"Jack", new Date()));
    }

    public  List<User> findAll() {
        return users;
    }

    public User save(User user){
        users.add(user);
        return user;
    }

    public User findById(int id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
