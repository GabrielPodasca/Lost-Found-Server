/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.UserDB;

/**
 *
 * @author Gabi
 */
@Stateless
public class UserDao extends AbstractFacade<UserDB> {

    @PersistenceContext(unitName = "LostFoundServer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDao() {
        super(UserDB.class);
    }
    
    public UserDB findUserByUsername(String username){
        Query q = getEntityManager().createNamedQuery("UserDB.findByUsername");
        q.setParameter("username", username);
        List<UserDB> users = q.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}
