/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.User;
import service.LoginService;

/**
 *
 * @author Gabi
 */
@WebService(serviceName = "LoginWS")
@Stateless()
public class LoginWS {

    @EJB
    private LoginService userService;
    
    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return userService.register(username, password);
    }

    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "user") User user) {
        return userService.login(user);
    }
    
}
