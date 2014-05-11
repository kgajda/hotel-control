/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.orm.NumberRoom;

/**
 *
 * @author karol
 */
@Repository
public class NumberRoomDOAImpl extends CustomHibernateDaoSupport implements NumberRoomDOA {

    @Transactional
    @Override
    public void save(NumberRoom numberRoom) {
        getSessionFactory().getCurrentSession().save(numberRoom);
    }

}
