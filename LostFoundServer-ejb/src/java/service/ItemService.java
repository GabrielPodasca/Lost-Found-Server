/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ItemDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.ItemDB;
import model.ItemList;

@Stateless
@LocalBean
public class ItemService {
    @EJB
    private ItemDao itemDao;
    
public String add(ItemDB item){

    
 String message = null;
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
                || item.getUserid()== null
                || (!item.getType().equals(ItemDB.LOST) && !item.getType().equals(ItemDB.FOUND))
         ) {
            message = "Not all fields are filled!";
            return message;
        }    
        try {
            itemDao.create(item);
            message = "OK";
            return message;           
        } catch (Exception e) {
            message = "Could not create item!";
            return message;
        }

                        
}

    public ItemList get() {
        ItemList itemList = null;
        try {
            List<ItemDB> items = itemDao.findAll();
            itemList = new ItemList(items);            
        } catch (Exception e) {
            itemList = new ItemList();
        }

        return itemList;
    }
}
