/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.convert.transport;

import org.springframework.stereotype.Component;
import pl.hotel.control.Transport.*;
import pl.hotel.control.orm.*;

/**
 *
 * @author karol
 */
@Component
public class ModelToOrm {
    public Account accountModelToOrm(AccountModel model){
        Account a = new Account();
        return accountModelToOrm(a, model);
        
    }
    public Account accountModelToOrm(Account account, AccountModel model){
        account.setRole_account(mp.getRole_account());
        account.setStatus(u.getStatus());
        return account;
    }
    
}
