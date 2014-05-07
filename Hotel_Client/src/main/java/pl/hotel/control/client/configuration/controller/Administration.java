/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.configuration.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import pl.hotel.control.client.configuration.Configuration;
import pl.hotel.control.transport.UserList;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping("/admin")
public class Administration {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Configuration c;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getAllUser() {
//        ResponseEntity<?> response = restTemplate.exchange(c.getConfiguration().getMyUrl("admin/user"), HttpMethod.GET, HttpEntity.EMPTY, Object.class);
       UserList res =restTemplate.getForObject(c.getConfiguration().getMyUrl("admin/user"), UserList.class);
         System.out.println("*************22222*******************");
        System.out.println(res);
        return "admin";
    }
}
