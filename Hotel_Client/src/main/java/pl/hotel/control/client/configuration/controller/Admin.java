/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.configuration.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import pl.hotel.control.Transport.AccountModel;
import pl.hotel.control.Transport.HotelModel;
import pl.hotel.control.Transport.HotelRoomModel;
import pl.hotel.control.Transport.RoomModel;
import pl.hotel.control.Transport.UserInfoModel;
import pl.hotel.control.client.properties.Properties;
import pl.hotel.control.client.properties.RestURI;
import pl.hotel.control.orm.UserInfo;

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

    @RequestMapping(value = {"/admin/account/{user}"}, method = RequestMethod.GET)
    public String showAccount(Model model, @PathVariable String user) throws IOException {
        String response = restTemplate.getForObject(RestURI.getUser(user), String.class);
        AccountModel accounts = mapper.readValue(response, AccountModel.class);
        model.addAttribute("accountModel", accounts);
        model.addAttribute("status", Properties.getStatus());
        model.addAttribute("role", Properties.getRole());
        return "account";
    }

    @RequestMapping(value = {"/admin/account/{user}"}, method = RequestMethod.POST)
    public String upDateAccount(Model model, @PathVariable String user, AccountModel accountModel) throws IOException {
        restTemplate.put(RestURI.getUser(user), accountModel);
        return showAccount(model, user);
    }

    @RequestMapping(value = {"/admin/hotel"}, method = RequestMethod.GET)
    public String showHotel(Model model) throws IOException {
        String response = restTemplate.getForObject(RestURI.HOTELS_URI, String.class);
        List hotelModelList = mapper.readValue(response, List.class);
        model.addAttribute("hotelModelList", hotelModelList);
        return "hotellist";
    }

    @RequestMapping(value = {"/admin/hotel/new"}, method = RequestMethod.GET)
    public String showRegistHotel(Model model) {
        HotelModel hotelModel = new HotelModel();
        model.addAttribute("hotelModel", hotelModel);
        return "newHotel";
    }

    @RequestMapping(value = {"/admin/hotel/new"},method = RequestMethod.POST)
    public String addNewHotel(@ModelAttribute("hotelModel") HotelModel hotelmodel,Model model) throws IOException {
        restTemplate.postForEntity(RestURI.ADMIN_HOTEL_URI, hotelmodel, ResponseEntity.class);

        return showHotel(model);
    }

}
