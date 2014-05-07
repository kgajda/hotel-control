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
import pl.hotel.control.database.connector.doa.HotelDOA;
import pl.hotel.control.database.connector.orm.Hotel;

/**
 *
 * @author karol
 */
@Service
public class HotelManager {
    
    @Autowired
    private HotelDOA hotelDOA;
    
    private final static Logger LOGGER = Logger.getLogger(HotelManager.class);
    
    public void save(Hotel hotel){
        hotelDOA.save(hotel);
        LOGGER.debug("Save hotel: "+hotel);
    }
    
    public List<Hotel> getAllHotels(){
        return hotelDOA.getAllHotels();
    }
    
}
