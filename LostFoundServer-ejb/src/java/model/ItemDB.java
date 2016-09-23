/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Gabi
 */
@Entity
@Table(name = "items")
@XmlRootElement
@XmlType(propOrder = { "id", "name", "description", "lat", "lng", "address", "when", "type", "userid" })
@NamedQueries({
    @NamedQuery(name = "ItemDB.findAll", query = "SELECT i FROM ItemDB i"),
    @NamedQuery(name = "ItemDB.findById", query = "SELECT i FROM ItemDB i WHERE i.id = :id"),
    @NamedQuery(name = "ItemDB.findByName", query = "SELECT i FROM ItemDB i WHERE i.name = :name"),
    @NamedQuery(name = "ItemDB.findByLat", query = "SELECT i FROM ItemDB i WHERE i.lat = :lat"),
    @NamedQuery(name = "ItemDB.findByLng", query = "SELECT i FROM ItemDB i WHERE i.lng = :lng"),
    @NamedQuery(name = "ItemDB.findByWhen", query = "SELECT i FROM ItemDB i WHERE i.when = :when"),
    @NamedQuery(name = "ItemDB.findByType", query = "SELECT i FROM ItemDB i WHERE i.type = :type")})
public class ItemDB implements Serializable {

    public static final String LOST = "LOST";
    public static final String FOUND = "FOUND";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lat")
    private double lat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lng")
    private double lng;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "whenDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "itemType")
    private String type;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserDB userid;

    public ItemDB() {
    }

    public ItemDB(Integer id) {
        this.id = id;
    }

    public ItemDB(Integer id, String name, String description, double lat, double lng, String address, Date when, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.when = when;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="user")
    public UserDB getUserid() {
        return userid;
    }

    public void setUserid(UserDB userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDB)) {
            return false;
        }
        ItemDB other = (ItemDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItemDB[ id=" + id + " ]";
    }
    
}
