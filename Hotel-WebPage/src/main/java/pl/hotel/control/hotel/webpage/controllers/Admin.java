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
            model.setRole_account(account.getRole_account());
            model.setStatus(account.getStatus());
            accountModels.add(model);
        }
        return accountModels;
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable String login,@RequestBody String user) throws IOException {
        AccountModel u = mapper.readValue(user, AccountModel.class);
        Account account = accountManager.findByLogin(login);
        account.setRole_account(u.getRole_account());
        account.setStatus(u.getStatus());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.GET)
    public @ResponseBody
    AccountModel getUser(@PathVariable String username) {
        Account account = accountManager.findByLogin(username);
        AccountModel model = new AccountModel();
        model.setEmail(model.getEmail());
        return model;
    }
    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<String> deleteUser(@PathVariable String username) {
       accountManager.delete(username);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/hotel"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> newHotel(@RequestBody String json) throws IOException {
        Hotel hotel = mapper.readValue(json, Hotel.class);
        hotelManager.save(hotel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
