/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.io.IOException;
import javax.validation.Valid;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.AbstractErrors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.Transport.AccountModel;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.UserInfo;
import pl.hotel.control.database.connector.service.AccountManager;
import pl.hotel.control.orm.Role;
import pl.hotel.control.orm.Status;
import pl.hotel.control.transport.RegisterModel;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = {"/registion"})
public class Registration {

    @Autowired
    private AccountManager accountManager;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> registion(@RequestBody String json) throws IOException {
        AccountModel register = mapper.readValue(json, AccountModel.class);
        Account account = new Account(register.getLogin(), register.getPassword(), register.getEmail(), Status.BLOCK, Role.USER);
        accountManager.save(account);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
