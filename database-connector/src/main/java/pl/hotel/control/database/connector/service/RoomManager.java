/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hotel.control.database.connector.doa.RoomDOA;
import pl.hotel.control.database.connector.doa.RoomDOAImpl;
import pl.hotel.control.orm.HotelRoom;
import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
@Service
public class RoomManager {

    @Autowired
    private RoomDOA roomDOA;
    @Autowired
    private HotelRoomManager hotelRoomManager;

    public void save(Room r) {
        for (HotelRoom object : r.getHotelRooms()) {
            object.setRoom(r);
            hotelRoomManager.save(object);
        }
        roomDOA.save(r);
    }
}
