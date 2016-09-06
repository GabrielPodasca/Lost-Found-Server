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
import service.LoginService;

/**
 *
 * @author Gabi
 */
@WebService(serviceName = "LoginWS")
@Stateless()
public class LoginWS {

    @EJB
    private LoginService loginService;

    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return loginService.register(username, password);
    }

    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return loginService.login(username, password);
    }
    
}
