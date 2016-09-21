/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ItemDao;
import java.nio.charset.Charset;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.Item;
import model.ItemDB;
import model.User;
import model.UserDB;

@Stateless
@LocalBean
public class ItemService {
    @EJB
    private ItemDao itemDao;
    
public void add(Item item){

 if (item == null
                || item.getName()== null
                || item.getName().trim().isEmpty()
                || item.getDescription()== null
                || item.getDescription().trim().isEmpty()
                || item.getAddress() == null
                || item.getAddress().trim().isEmpty()
                || item.getLat() <= 0
                || item.getLng() <= 0 
                || item.getWhen() == null
                || item.getUser() == null
                || (!item.getType().equals(Item.LOST) && !item.getType().equals(Item.FOUND))
         ) {
            return;
        }    
        
        ItemDB itemDB = new ItemDB(0, item.getName(), item.getDescription(), item.getLat(), item.getLng(), 
                        item.getAddress(), item.getWhen(), item.getType()
                    );
        User user = item.getUser();
        UserDB userDB = new UserDB(user.getId(), user.getUsername(), user.getPassword(), user.getTelephone());
        itemDB.setUserid(userDB);
        itemDao.create(itemDB);
                        
}
}
