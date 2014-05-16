/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.configuration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hotel.control.Transport.AccountModel;

/**
 *
 * @author karol
 */
@Controller
public class Home {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showPage(Model model) {
        return "home";
    }
}
