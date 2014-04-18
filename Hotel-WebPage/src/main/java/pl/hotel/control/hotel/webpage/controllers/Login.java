/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.service.AccountManager;
import pl.hotel.control.hotel.webpage.controllers.model.LoginModel;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = {"/login"})
public class Login {
    @Autowired
    private AccountManager accountManager;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String newLogin(LoginModel model) {
        System.out.println(model.getLogin()+":"+model.getPassword());
        accountManager.save(new Account(model.getLogin(), model.getPassword(), "da", true));
        return "home";
    }
}
