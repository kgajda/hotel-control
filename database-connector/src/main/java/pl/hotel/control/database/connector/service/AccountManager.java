package pl.hotel.control.database.connector.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hotel.control.database.connector.doa.AccountDOA;
import pl.hotel.control.database.connector.orm.Account;

/**
 *
 * @author karol
 */
@Service
public class AccountManager {

    @Autowired
    private AccountDOA accountDOA;


    public void save(Account stock) {
        accountDOA.save(stock);
    }

    public void update(Account stock) {
        accountDOA.update(stock);
    }

    public void delete(Account stock) {
        accountDOA.delete(stock);
    }

    public Account findByName(String name) {
        return accountDOA.findByName(name);
    }
}
