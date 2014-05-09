/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.Hotel;
import pl.hotel.control.orm.Room;
import pl.hotel.control.database.connector.service.AccountManager;
import pl.hotel.control.database.connector.service.HotelManager;
import pl.hotel.control.transport.HotelTransport;
import pl.hotel.control.transport.HotelsTransport;
import pl.hotel.control.transport.RoomsTransport;
import pl.hotel.control.transport.User;
import pl.hotel.control.transport.UserList;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping("admin")
public class Admin {

    @Autowired
    private AccountManager accountManager;
    @Autowired
    private HotelManager hotelManager;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public @ResponseBody
    List<Account> getAllUser() {
        List<Account> accountList = accountManager.getAllAccount();

        return accountList;
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.GET)
    public @ResponseBody
    Account getUser(@PathVariable String username) {
        Account account = accountManager.findByName(username);
        return account;
    }
//TODO: dorobić update

    @RequestMapping(value = {"/user"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody User upUser) {
        Account account = accountManager.findByName(upUser.getLogin());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/hotel"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> newHotel(@RequestBody String json) throws IOException {
        Hotel hotel = mapper.readValue(json, Hotel.class);
        hotelManager.save(hotel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
