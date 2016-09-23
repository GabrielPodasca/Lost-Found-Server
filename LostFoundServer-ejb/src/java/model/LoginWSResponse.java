/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabi
 */
public class LoginWSResponse {
    private UserDB user;
    private String message;

    public LoginWSResponse() {
    }

    public LoginWSResponse(UserDB user, String message) {
        this.user = user;
        this.message = message;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
