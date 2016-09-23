/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import model.ItemDB;
import model.ItemList;
import service.ItemService;

/**
 *
 * @author Gabi
 */
@WebService(serviceName = "ItemsWS")
@Stateless()
public class ItemsWS {
    
    @EJB
    private ItemService itemService;
    
    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "item") ItemDB item) {
        return itemService.add(item);
    }
    
    @WebMethod(operationName = "get")
    @WebResult(name="items")
    public ItemList get() {
        return itemService.get();
    }
    
//    @WebMethod(operationName = "test")
//    public void test(@WebParam(name = "items") List<Item> items) {
//
//    }    
    
//     @WebMethod(operationName = "test1")
//     @XmlElementWrapper(name="items")
//     @XmlElement(name="item")
//    public  ArrayList<Item> test1() {
//        ArrayList<Item> items = new ArrayList<>();
//        Item i1 = new Item();
//        i1.setAddress("a");
//          Item i2 = new Item();
//        i1.setAddress("b");      
//        items.add(i1);
//        items.add(i2);
//        return items;
//    } 
    
}
