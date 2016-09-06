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
import model.User;

/**
 *
 * @author Gabi
 */
@Stateless
public class UserDao extends AbstractFacade<User> {

    @PersistenceContext(unitName = "LostFoundServer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDao() {
        super(User.class);
    }
    
    public User findUserByUsername(String username){
        Query q = getEntityManager().createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        List<User> users = q.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}
