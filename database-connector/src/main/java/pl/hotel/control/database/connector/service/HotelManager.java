/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.doa.HotelDOA;
import pl.hotel.control.orm.Hotel;
import pl.hotel.control.orm.HotelRoom;

/**
 *
 * @author karol
 */
@Service
public class HotelManager {

    @Autowired
    private HotelDOA hotelDOA;
    @Autowired
    private HotelRoomManager roomManager;

    private final static Logger LOGGER = Logger.getLogger(HotelManager.class);

    @Transactional
    public void save(Hotel hotel) {
        for (HotelRoom hotelRoom : hotel.getRoom()) {
            hotelRoom.setHotel(hotel);
            roomManager.save(hotelRoom);
        }
        hotelDOA.save(hotel);
        LOGGER.info("INSERT HOTEL: " + hotel.toString());
    }

    public Hotel getHotel(String name) {
        return hotelDOA.findByName(name);
    }

    public Hotel getHotel(Integer id) {
        return hotelDOA.findById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelDOA.getAllHotels();
    }

}
