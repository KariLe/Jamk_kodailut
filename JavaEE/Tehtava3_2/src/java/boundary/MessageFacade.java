/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Message;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kari
 * Stateless session bean, joka on periytynyt AbstractFacade.javasta
 */

@Stateless
public class MessageFacade extends AbstractFacade<Message> {
    //inject the entity manager resource into the session bean component and to specify the name of the persistence unit.
    @PersistenceContext(unitName = "Tehtava3_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageFacade() {
        super(Message.class);
    }
    
}
