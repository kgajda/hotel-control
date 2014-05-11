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

    /**
     * Zapisuje nowe konto
     *
     * @param account
     */
    void save(Account account);

    /**
     * Update Account
     *
     * @param account
     */
    void update(Account account);

    /**
     * Usuwa konto z db
     *
     * @param account
     */
    void delete(Account account);

    /**
     * Wyszukuje konto na podstawie loginu.
     *
     * @param name login
     * @return Account or Null
     */
    Account findByName(String name);
    /**
     * Wyszukuje konto na podstawie id
     * @param id
     * @return 
     */
    Account findById(String id);

    /**
     * Zwraca listę wszystkich kont zapisanych w db
     *
     * @return
     */
    List<Account> getAllAccount();

}
