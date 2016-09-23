
package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public class ItemList {
    
    private List<ItemDB> list;
    
    public ItemList() {
        this.list = new ArrayList<ItemDB>();
    }
    
    public ItemList(List<ItemDB> list) {
        this.list = list;
    }

    @XmlElement(name = "item")
    public List<ItemDB> getList() {
        return list;
    }

    public void setList(List<ItemDB> list) {
        this.list = list;
    }
    
    
    
}

