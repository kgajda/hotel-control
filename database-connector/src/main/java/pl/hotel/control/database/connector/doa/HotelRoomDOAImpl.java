/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.orm.HotelRoom;

/**
 *
 * @author karol
 */
@Repository
public class HotelRoomDOAImpl extends CustomHibernateDaoSupport implements HotelRoomDOA{
    @Transactional
    @Override
    public void save(HotelRoom hotelRoom) {
        getSessionFactory().getCurrentSession().saveOrUpdate(hotelRoom);
    }
    
}
