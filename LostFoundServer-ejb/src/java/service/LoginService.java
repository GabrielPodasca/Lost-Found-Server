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

@Stateless
@LocalBean
public class LoginService {
    
    @EJB
    private UserDao userDao;

    public boolean register(User user){
        
        if (user == null
                || user.getUsername() == null
                || user.getUsername().trim().isEmpty()
                || user.getPassword() == null
                || user.getPassword().trim().isEmpty()
                || user.getTelephone() == null
                || user.getTelephone().trim().isEmpty()) {
            return false;
        }

        UserDB userDB = userDao.findUserByUsername(user.getUsername());
        if(userDB == null){
            userDB = new UserDB();
            userDB.setUsername(user.getUsername());
            userDB.setPassword(user.getPassword());
            userDB.setTelephone(user.getTelephone());
            userDao.create(userDB);
            return true;
        }
        
        return false;
    }
    
    public User login(User user){
        
        if (user == null
                || user.getUsername() == null
                || user.getUsername().trim().isEmpty()
                || user.getPassword() == null
                || user.getPassword().trim().isEmpty()) {
            return null;
        }
        
        UserDB userDB = userDao.findUserByUsername(user.getUsername());
                 
        
        if (userDB != null 
                && user.getPassword().equals(userDB.getPassword())
                ) {
            user.setId(userDB.getId());
            user.setTelephone(userDB.getTelephone());
            return user;
        }
        
        return null;
    }
}
