/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
public interface RoomDOA {
    
    void save(Room room);
}
