/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;
import model.Item;
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
    public void add(@WebParam(name = "item") Item item) {
        itemService.add(item);
    }
}
