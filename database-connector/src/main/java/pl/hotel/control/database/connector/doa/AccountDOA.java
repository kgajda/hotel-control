/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import pl.hotel.control.database.connector.orm.Account;

/**
 *
 * @author karol
 */
public interface AccountDOA {

    void save(Account account);

    void update(Account account);

    void delete(Account account);

    Account findByName(String name);

}
