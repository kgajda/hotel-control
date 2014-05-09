package pl.hotel.control.database.connector.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hotel.control.database.connector.doa.AccountDOA;
import pl.hotel.control.orm.Account;

/**
 *
 * @author karol
 */
@Service
public class AccountManager {

    @Autowired
    private AccountDOA accountDOA;

    private final static Logger LOGGER = Logger.getLogger(AccountManager.class);

    public void save(Account stock) {
        accountDOA.save(stock);
        LOGGER.info("SAVE ACCOUNT: " + stock.toString());
    }

    public void update(Account stock) {
        accountDOA.update(stock);
        LOGGER.debug(stock);
    }

    public void delete(Account stock) {
        accountDOA.delete(stock);
        LOGGER.debug(stock);
    }

    public Account findByName(String name) {
        return accountDOA.findByName(name);
    }

    public List<Account> getAllAccount() {
        return accountDOA.getAllAccount();
    }

    public boolean isExist(String login) {
        if (findByName(login) != null) {
            return true;
        } else {
            return false;
        }
    }

}
