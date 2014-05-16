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

/**
 *
 * @author karol
 */
@Controller
public class Admin {
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String showPage(Model model) {
        return "admin";
    }
    @RequestMapping(value = {"/admin/account"}, method = RequestMethod.GET)
    public String showAccount(Model model) {
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
