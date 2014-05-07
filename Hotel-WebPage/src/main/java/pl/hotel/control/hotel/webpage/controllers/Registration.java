/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.hotel.webpage.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.AbstractErrors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.UserInfo;
import pl.hotel.control.database.connector.service.AccountManager;
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
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> registion(RegisterModel register){
        Account acc = new Account();
        acc.setActive(false);
        acc.setEmail(register.getEmail());
        acc.setLogin(register.getLogin());
        acc.setPassword(register.getPassword());
        UserInfo userinfo = new UserInfo();
        userinfo.setAdress(register.getAdress());
        userinfo.setName(register.getName());
        userinfo.setPhone(register.getPhone());
        userinfo.setSourName(register.getSourName());
        userinfo.setRole("user");
        acc.setUserInfo(userinfo);
        accountManager.save(acc);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
