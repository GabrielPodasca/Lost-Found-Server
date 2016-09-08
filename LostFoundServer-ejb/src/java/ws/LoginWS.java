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
import javax.jws.WebResult;
import model.LoginWSResponse;
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
    @WebResult(name="loginWSResponse")
    public LoginWSResponse register(@WebParam(name = "user") User user) {
        return userService.register(user);
    }

    @WebMethod(operationName = "login")
    @WebResult(name="loginWSResponse")
    public LoginWSResponse login(@WebParam(name = "user") User user) {
        return userService.login(user);
    }
    
}
