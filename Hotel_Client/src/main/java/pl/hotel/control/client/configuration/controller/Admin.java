/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.configuration.controller;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Admin {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String showPage(Model model) {
        return "admin";
    }

    @RequestMapping(value = {"/admin/account"}, method = RequestMethod.GET)
    public String showAccount(Model model) throws IOException {
        String response = restTemplate.getForObject(RestURI.ADMIN_USERS_URI, String.class);
        List<AccountModel> accounts = mapper.readValue(response, List.class);
        model.addAttribute("accountlist", accounts);
        return "accountlist";
    }

    @RequestMapping(value = {"/admin/hotel"}, method = RequestMethod.GET)
    public String showHotel(Model model) {
        return "admin";
    }

    @RequestMapping(value = {"/admin/reservation"}, method = RequestMethod.GET)
    public String showReservation(Model model) {
        return "admin";
    }
}
