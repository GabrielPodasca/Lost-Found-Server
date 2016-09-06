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
        User user = userDao.findUserByUsername(username);
        if(user == null){
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDao.create(user);
            return "Userul a fost adaugat";
        }
        return "Userul exista deja";
    }
    
    public String login(String username, String password){
        User user = userDao.findUserByUsername(username);
        if (user!=null 
                && user.getPassword().equals(password)
                ) {
            return "OK";
        }
        return "NOK";
    }
}
