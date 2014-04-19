/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.hotel.webpage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.service.AccountManager;
import java.util.List;

/**
 *
 * @author karol
 */
@Controller
@RequestMapping(value = "/list")
public class ListIthem {
    @Autowired
    private AccountManager accountManager;
    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model){
       List<Account> accountlist = accountManager.getAllAccount();
        for (Account account : accountlist) {
            accountManager.findByName(account.getLogin());
            
        }
        accountManager.findByName("asdad");
       model.addAttribute("accountlist",accountlist);
        return "list";
    }
    
}
