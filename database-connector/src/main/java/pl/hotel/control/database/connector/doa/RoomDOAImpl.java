/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
@Repository
public class RoomDOAImpl extends CustomHibernateDaoSupport implements RoomDOA{
    @Transactional
    @Override
    public void save(Room room) {
        getSessionFactory().getCurrentSession().save(room);
    }
    
    
    
}
