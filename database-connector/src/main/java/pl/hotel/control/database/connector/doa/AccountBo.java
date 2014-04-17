/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hotel.control.database.connector.orm.Account;

/**
 *
 * @author karol
 */
@Service
public class AccountBo {

    @Autowired
    AccountDOA accountDOA;


    public void save(Account stock) {
        accountDOA.save(stock);
    }

    public void update(Account stock) {
        accountDOA.update(stock);
    }

    public void delete(Account stock) {
        accountDOA.delete(stock);
    }

    public Account findByStockCode(String stockCode) {
        return accountDOA.findByStockCode(stockCode);
    }
}
