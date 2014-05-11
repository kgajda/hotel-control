/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.orm.Reservation;

/**
 *
 * @author karol
 */
@Repository
public class ReservationDOAImpl extends CustomHibernateDaoSupport implements ReservationDOA {

    @Transactional
    @Override
    public void save(Reservation r) {
        getSessionFactory().getCurrentSession().save(r);
    }

    @Transactional
    @Override
    public void update(Reservation r) {
        getSessionFactory().getCurrentSession().update(r);
    }

}
