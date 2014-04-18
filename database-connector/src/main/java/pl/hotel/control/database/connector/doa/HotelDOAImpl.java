/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import java.util.List;
import javax.transaction.Transactional;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.Hotel;

/**
 *
 * @author karol
 */
public class HotelDOAImpl extends CustomHibernateDaoSupport implements HotelDOA {

    @Transactional
    @Override
    public void save(Hotel hotel) {
        getHibernateTemplate().save(hotel);
    }

    @Transactional
    @Override
    public void update(Hotel hotel) {
        getHibernateTemplate().update(hotel);
    }

    @Transactional
    @Override
    public void delete(Hotel hotel) {
        getHibernateTemplate().delete(hotel);
    }

    @Transactional
    @Override
    public Account findByName(String name) {
        List list = getHibernateTemplate().find(
                "from ACCOUNT where name=?", name
        );
        return (Account) list.get(0);
    }

}
