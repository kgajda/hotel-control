/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import java.util.List;
import pl.hotel.control.orm.Account;

/**
 *
 * @author karol
 */
public interface AccountDOA {

    void save(Account account);

    void update(Account account);

    void delete(Account account);

    /**
     * Wyszukuje konto na podstawie loginu.
     *
     * @param name login
     * @return Account or Null
     */
    Account findByName(String name);

    List<Account> getAllAccount();

}
