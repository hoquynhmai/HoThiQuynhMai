package com.codegym.dao;

import com.codegym.entity.Login;
import com.codegym.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User("john","123456","John","john@codegym.vn",10);
        User u2 = new User("bill","123456","Bill","bill@codegym.vn",15);
        User u3 = new User("mike","123456","Mike","mike@codegym.vn",16);
        User u4 = new User("mai","hoquynhmai","Hồ Quỳnh Mai","hoquynhmai1505@gmail.com",25);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
    }

    public static User checkLogin(Login login){
        for (User element: users) {
            if(element.getAccount().equals(login.getAccount())
                    && element.getPassword().equals(login.getPassword())){
                return element;
            }
        }
        return null;
    }
}

//        u3.setAge(16);
//        u3.setName("Mike");
//        u3.setAccount("mike");
//        u2.setEmail("mike@codegym.vn");
//        u3.setPassword("123456");
