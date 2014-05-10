/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.database.connector.service.HotelManager;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = {"/hotel"})
public class HotelController {

    @Autowired
    private HotelManager hotelManager;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public @ResponseBody
    List<pl.hotel.control.orm.Hotel> getAllHotel() {
        List<pl.hotel.control.orm.Hotel> hotels = hotelManager.getAllHotels();
        return hotels;
    }
    @RequestMapping(value = {"/{name}"}, method = RequestMethod.GET)
    public @ResponseBody
    pl.hotel.control.orm.Hotel getHotel(@PathVariable String name) {
       return hotelManager.getHotel(name);
        
    }
}
