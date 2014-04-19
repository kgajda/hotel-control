/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author karol
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    @Resource
    public void hibernateDaoSupport(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

}
