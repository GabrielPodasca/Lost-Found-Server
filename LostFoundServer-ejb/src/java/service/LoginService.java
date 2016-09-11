/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import helper.CryptPassword;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.LoginWSResponse;
import model.User;
import model.UserDB;

@Stateless
@LocalBean
public class LoginService {
    
    @EJB
    private UserDao userDao;

    public LoginWSResponse register(User user){
        
        LoginWSResponse loginWSResponse = new LoginWSResponse();
        if (user == null
                || user.getUsername() == null
                || user.getUsername().trim().isEmpty()
                || user.getPassword() == null
                || user.getPassword().trim().isEmpty()
                || user.getTelephone() == null
                || user.getTelephone().trim().isEmpty()) {
            loginWSResponse.setMessage("Please fill all the data!");
            return loginWSResponse;
        }

        UserDB userDB = userDao.findUserByUsername(user.getUsername());
        if(userDB == null){
            userDB = new UserDB();
            userDB.setUsername(user.getUsername());
            String password = CryptPassword.cryptWithMD5(user.getPassword());
            userDB.setPassword(password);
            userDB.setTelephone(user.getTelephone());
            userDao.create(userDB);
            loginWSResponse.setUser(user);
            loginWSResponse.setMessage("Successful registration!");
            return loginWSResponse;
        }
        
        loginWSResponse.setMessage("User already exists!");
        
        return loginWSResponse;
    }
    
    public LoginWSResponse login(User user){
        
        LoginWSResponse loginWSResponse = new LoginWSResponse();
        if (user == null
                || user.getUsername() == null
                || user.getUsername().trim().isEmpty()
                || user.getPassword() == null
                || user.getPassword().trim().isEmpty()) {
            loginWSResponse.setMessage("Please fill all the data!");
            return loginWSResponse;
        }
        
        UserDB userDB = userDao.findUserByUsername(user.getUsername());
  
        if (userDB != null) {
            String password = CryptPassword.cryptWithMD5(user.getPassword());
            if (password.equals(userDB.getPassword())) {
                user.setId(userDB.getId());
                user.setTelephone(userDB.getTelephone());
                loginWSResponse.setUser(user);
                loginWSResponse.setMessage("Successful login!");
                return loginWSResponse; 
            }
            loginWSResponse.setMessage("Wrong password!");
        }                         
        
        loginWSResponse.setMessage("Inexistent user!");
        return loginWSResponse;
    }
}
