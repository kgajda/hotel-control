/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.Transport.HotelModel;
import pl.hotel.control.database.connector.service.HotelManager;
import pl.hotel.control.orm.Hotel;

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

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<HotelModel> getAllHotel() {
        List<pl.hotel.control.orm.Hotel> hotels = hotelManager.getAllHotels();
        List<HotelModel> hotelModels = new LinkedList<>();
        for (Hotel hotel : hotels) {
            HotelModel hotelModel = new HotelModel();
            hotelModel.setCity(hotel.getCity());
            hotelModel.setId(hotel.getId());
            hotelModel.setRooms(hotel.getRoom().size());
            hotelModel.setStars(hotel.getStars());
            hotelModels.add(hotelModel);
        }

        return hotelModels;
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveNewHotel() {
        

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = {"/{name}"}, method = RequestMethod.GET)
    public @ResponseBody
    pl.hotel.control.orm.Hotel getHotel(@PathVariable String name) {
        return hotelManager.getHotel(name);

    }
}
