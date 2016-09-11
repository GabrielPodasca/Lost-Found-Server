/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabi
 */
public final class CryptPassword {
    private static MessageDigest md;
    
    private CryptPassword(){
        
    }
    
    public static String cryptWithMD5(String pass){
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            byte [] password = pass.getBytes();
            byte [] digested = md.digest(password);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
