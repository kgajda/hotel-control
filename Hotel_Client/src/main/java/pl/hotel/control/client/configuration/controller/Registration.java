/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.configuration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import pl.hotel.control.Transport.AccountModel;
import pl.hotel.control.client.properties.RestURI;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping("/registration")
public class Registration {

    RestTemplate rest = new RestTemplate();

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(Model model) {
        AccountModel account = new AccountModel();
        model.addAttribute("accountModel", account);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showPage(AccountModel model) {
        ResponseEntity response = rest.postForEntity(RestURI.REGISTRATION_URI, model, ResponseEntity.class);
        if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
            return "home";
        } else {
            return "login";
        }
    }

}
