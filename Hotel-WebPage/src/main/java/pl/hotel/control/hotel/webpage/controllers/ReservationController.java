/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.hotel.webpage.controllers;

import java.io.IOException;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hotel.control.orm.Reservation;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = "/reservation/")
public class ReservationController {
    @Autowired
    private ObjectMapper mapper;
    @RequestMapping(value = {"/"},method = RequestMethod.POST)
    public ResponseEntity<String> saveReservation(@RequestBody String reservation) throws IOException{
        Reservation newr = mapper.readValue(reservation, Reservation.class);
        
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
