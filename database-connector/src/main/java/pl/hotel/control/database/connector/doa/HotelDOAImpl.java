/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.Hotel;
import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
@Repository
public class HotelDOAImpl extends CustomHibernateDaoSupport implements HotelDOA {

    @Transactional
    @Override
    public void save(Hotel hotel) {
        getSessionFactory().getCurrentSession().saveOrUpdate(hotel);
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
    public Hotel findByName(String name) {
        List list = getHibernateTemplate().find(
                "from Hotel where name=?", name
        );
        return (Hotel) list.get(0);
    }

    @Transactional
    @Override
    public Hotel findById(Integer id) {
        List list = getHibernateTemplate().find(
                "from Hotel where id=?", id
        );
        return (Hotel) list.get(0);
    }

    @Transactional
    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = getSessionFactory().getCurrentSession().createCriteria(Hotel.class).list();
        return hotels;
    }

}
