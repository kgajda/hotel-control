/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.orm.Account;

/**
 *
 * @author karol
 */
@Repository
public class AccountDOAImpl extends CustomHibernateDaoSupport implements AccountDOA {

    @Transactional
    @Override
    public void save(Account account) {
        getSessionFactory().getCurrentSession().save(account);
    }

    @Transactional
    @Override
    public void update(Account account) {
        getSessionFactory().getCurrentSession().update(account);
    }

    @Transactional
    @Override
    public void delete(Account accoount) {
        getSessionFactory().getCurrentSession().delete(accoount);
    }

    @Transactional
    @Override
    public Account findByName(String login) {
        System.out.println(login);
        List list = getSessionFactory().getCurrentSession().createQuery("from Account where login = ?").setString(0, login).list();
        if (list.size() == 1) {
            return (Account) list.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public List<Account> getAllAccount() {
        List<Account> list = getSessionFactory().getCurrentSession().createCriteria(Account.class).list();
        return list;
    }

}
