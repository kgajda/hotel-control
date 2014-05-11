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
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.doa.AccountDOA;
import pl.hotel.control.database.connector.doa.ReservationDOA;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.Reservation;

/**
 *
 * @author karol
 */
@Service
public class AccountManager {

    @Autowired
    private AccountDOA accountDOA;
    @Autowired
    private ReservationDOA reservationManager;

    private final static Logger LOGGER = Logger.getLogger(AccountManager.class);

    @Transactional
    public void save(Account stock) {
        for (Reservation reservation : stock.getStockDailyRecords()) {
            reservation.setAccount(stock);
            reservationManager.save(reservation);
        }
        accountDOA.save(stock);
        LOGGER.info("SAVE ACCOUNT: " + stock.toString());
    }

    public void update(Account stock) {
        for (Reservation reservation : stock.getStockDailyRecords()) {
            reservation.setAccount(stock);
            reservationManager.update(reservation);
        }
        accountDOA.update(stock);
        LOGGER.info("UPDATE ACOUNT");
    }

    public void delete(Account stock) {
        accountDOA.delete(stock);
        LOGGER.info("DELETE ACCOUNT: " + stock.toString());
    }

    public void delete(String stock) {
        Account c = findByLogin(stock);
        accountDOA.delete(c);
    }

    public Account findByLogin(String login) {
        return accountDOA.findByName(login);
    }

    public Account findById(String id) {
        return accountDOA.findById(id);
    }

    public List<Account> getAllAccount() {
        return accountDOA.getAllAccount();
    }

    public boolean isExist(String login) {
        if (findByLogin(login) != null) {
            return true;
        } else {
            return false;
        }
    }

}
