/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.Hotel;
import pl.hotel.control.database.connector.service.AccountManager;
import pl.hotel.control.database.connector.service.HotelManager;
import pl.hotel.control.Transport.*;
import pl.hotel.control.orm.HotelRoom;
import pl.hotel.control.orm.NumberRoom;
import pl.hotel.control.orm.Role;
import pl.hotel.control.orm.Room;
import pl.hotel.control.orm.Status;

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
    List<AccountModel> getAllUser() {
        List<Account> accountList = accountManager.getAllAccount();
        List<AccountModel> accountModels = new LinkedList<>();
        for (Account account : accountList) {
            AccountModel model = new AccountModel();
            model.setEmail(account.getEmail());
            model.setId(account.getId());
            model.setLogin(account.getLogin());
            model.setRole_account(account.getRole_account().name());
            model.setStatus(account.getStatus().toString());
            accountModels.add(model);
        }
        return accountModels;
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody String user) throws IOException {
        AccountModel u = mapper.readValue(user, AccountModel.class);
        Account account = accountManager.findByLogin(username);
        account.setStatus(Status.valueOf(u.getStatus()));
        account.setRole_account(Role.valueOf(u.getRole_account()));
        accountManager.update(account);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.GET)
    public @ResponseBody
    AccountModel getUser(@PathVariable String username) {
        Account account = accountManager.findByLogin(username);
        AccountModel model = new AccountModel();
        model.setEmail(account.getEmail());
        model.setLogin(account.getLogin());
        model.setId(account.getId());
        model.setStatus(account.getStatus().toString());
        model.setRole_account(account.getRole_account().name());
        UserInfoModel infoModel = new UserInfoModel(account.getUserInfo().getName(), account.getUserInfo().getSourName(), account.getUserInfo().getAdress(), account.getUserInfo().getPhone());
        model.setUserInfo(infoModel);
        return model;
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<String> deleteUser(@PathVariable String username) {
        accountManager.delete(username);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/hotel"}, method = RequestMethod.POST)
    public ResponseEntity<String> newHotel(@RequestBody String json) throws IOException {
        HotelModel hotelModel = mapper.readValue(json, HotelModel.class);
        Hotel newHotel = new Hotel(hotelModel.getName(), hotelModel.getCity(), hotelModel.getStars());
        hotelManager.save(newHotel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/hotel/{id}"}, method = RequestMethod.GET)
    public @ResponseBody
    HotelModel getHotel(@PathVariable String id) throws IOException {
        Hotel hotel = hotelManager.getHotel(Integer.parseInt(id));
        HotelModel hotelModel = new HotelModel();
        hotelModel.setCity(hotel.getCity());
        hotelModel.setId(hotel.getId());
        hotelModel.setName(hotel.getName());
        hotelModel.setRooms(hotel.getRoom().size());
        hotelModel.setStars(hotel.getStars());
        List<HotelRoomModel> hotelRoomModels = new LinkedList<>();
        for (HotelRoom hotelRoom : hotel.getRoom()) {
            HotelRoomModel hotelRoomModel = new HotelRoomModel();
            hotelRoomModel.setNumber(hotelRoom.getNumber().getId());
            hotelRoomModel.setBed(hotelRoom.getRoom().getBed());
        }
        hotelModel.setRoom(hotelRoomModels);
        return hotelModel;
    }

    @RequestMapping(value = {"/hotel/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<String> getHotel(@PathVariable String id, @RequestBody String json) throws IOException {
        HotelModel hotelModel = mapper.readValue(json, HotelModel.class);
        Hotel hotel = hotelManager.getHotel(hotelModel.getId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
