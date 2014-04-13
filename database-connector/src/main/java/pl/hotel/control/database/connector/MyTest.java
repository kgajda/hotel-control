/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import pl.hotel.control.database.connector.orm.Account;

/**
 *
 * @author karol
 */
public class MyTest {
    private SessionFactory sessionFactory;

    public void set(SessionFactory sessionFactory) {
        System.out.println("#########################3");
        System.out.println("#########################3");
        System.out.println("#########################3");
        System.out.println("#########################3");
        System.out.println("#########################3");
        this.sessionFactory = sessionFactory;
    }
    
    
    
    public void insert(){
        System.out.println("#########################3");
        sessionFactory.openSession().save(new Account("123", "123", "123", true));
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
}
