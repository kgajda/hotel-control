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
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.Hotel;
import pl.hotel.control.database.connector.orm.Room;
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
    UserList getAllUser() {
        List<Account> accountList = accountManager.getAllAccount();
        List<User> userlist = new LinkedList<>();
        for (Account account : accountList) {
            User user = new User();
            user.setActive(account.isActive());
            user.setAdress(account.getUserInfo().getAdress());
            user.setLogin(account.getLogin());
            user.setName(account.getUserInfo().getName());
            user.setSurname(account.getUserInfo().getSourName());
            user.setPhone(account.getUserInfo().getPhone());
            userlist.add(user);
        }
        return new UserList(userlist);
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable String username) {
        Account account = accountManager.findByName(username);
        User user = new User();
        user.setActive(account.isActive());
        user.setAdress(account.getUserInfo().getAdress());
        user.setLogin(account.getLogin());
        user.setName(account.getUserInfo().getName());
        user.setSurname(account.getUserInfo().getSourName());
        user.setPhone(account.getUserInfo().getPhone());
        return user;
    }

    @RequestMapping(value = {"/user/update"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody User upUser) {
        Account account = accountManager.findByName(upUser.getLogin());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = {"/hotel/new"},method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<String> newHotel(@RequestBody String json) throws IOException{
        HotelTransport hotelTransport = mapper.readValue(json, HotelTransport.class);
        Hotel newHotel = new Hotel();
        newHotel.setCity(hotelTransport.getName());
        newHotel.setName(hotelTransport.getName());
        Set<Room> newRoms = new HashSet<>();
        for (RoomsTransport roomtransport : hotelTransport.getRooms()) {
            Room room = new Room();
            room.setBed(roomtransport.getBed());
            room.setNumber(roomtransport.getNumber());
            room.setStars(roomtransport.getStars());
            newRoms.add(room);
        }
        newHotel.setRoom(newRoms);
        hotelManager.save(newHotel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = {"/hotel"},method = RequestMethod.GET)
    public @ResponseBody List<Hotel> getAllHotel(){
        List<Hotel> hotels = hotelManager.getAllHotels();
        HotelsTransport hotelsTransport = new HotelsTransport();
        for (Hotel hotel : hotels) {
            HotelTransport hotelTransport = new HotelTransport();
            hotelTransport.setCity(hotel.getCity());
            hotelTransport.setName(hotel.getName());
            List<RoomsTransport> roomsTransports = new LinkedList<>();
//            for (Room room : hotel.getRoom()) {
//                RoomsTransport roomsTransport = new RoomsTransport();
//                roomsTransport.setBed(room.getBed());
//                roomsTransport.setNumber(room.getNumber());
//                roomsTransport.setStars(room.getStars());
//                roomsTransports.add(roomsTransport);
//            }
            hotelTransport.setRooms(roomsTransports);
        }
        return hotels;
    }
}
