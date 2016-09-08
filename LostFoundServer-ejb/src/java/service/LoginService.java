/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.User;
import model.UserDB;

/**
 *
 * @author student
 */
@Stateless
@LocalBean
public class LoginService {
    
    @EJB
    private UserDao userDao;

    public String register(String username, String password){
        UserDB user = userDao.findUserByUsername(username);
        if(user == null){
            user = new UserDB();
            user.setUsername(username);
            user.setPassword(password);
            userDao.create(user);
            return "Userul a fost adaugat";
        }
        return "Userul exista deja";
    }
    
    public User login(User user){
        if (user == null
                || user.getUsername() == null
                || user.getPassword() == null
                ) 
            return null;
        
        UserDB userDB = userDao.findUserByUsername(user.getUsername());
                 
        
        if (userDB != null 
                && user.getPassword().equals(userDB.getPassword())
                ) {
            return user;
        }
        
        return null;
    }
}
