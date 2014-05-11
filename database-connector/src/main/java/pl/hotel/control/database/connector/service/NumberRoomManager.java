/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.doa.NumberRoomDOA;
import pl.hotel.control.orm.HotelRoom;
import pl.hotel.control.orm.NumberRoom;

/**
 *
 * @author karol
 */
@Service
public class NumberRoomManager {
    @Autowired
    private NumberRoomDOA numberRoomDOA;
    @Autowired
    private HotelRoomManager hotelRoomManager;
    @Transactional
    public void save(NumberRoom numberRoom){
        for (HotelRoom hotelRoom : numberRoom.getHottelRooms()) {
            hotelRoom.setNumber(numberRoom);
            hotelRoomManager.save(hotelRoom);
        }
        numberRoomDOA.save(numberRoom);
    }
    
}
