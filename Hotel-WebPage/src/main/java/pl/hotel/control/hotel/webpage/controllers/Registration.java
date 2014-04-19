/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.hotel.webpage.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.UserInfo;
import pl.hotel.control.database.connector.service.AccountManager;
import pl.hotel.control.hotel.webpage.controllers.model.RegisterModel;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = {"/registion"})
public class Registration {
    @Autowired
    private AccountManager accountManager;
    
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistion(Model model){
        model.addAttribute(new RegisterModel());
        return "registion";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String registion(@Valid RegisterModel register,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "registion";
        }
        Account account = new Account(register.getLogin(), register.getPassword1(), register.getMail(), false);
        account.setUserInfo(new UserInfo(register.getName(), register.getSourname(), register.getAddres(), "user", register.getPhone()));
        accountManager.save(account);
        return "status";
    }
}
