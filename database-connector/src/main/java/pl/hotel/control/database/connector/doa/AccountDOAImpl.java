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
        getHibernateTemplate().save(account);
    }

    @Transactional
    @Override
    public void update(Account account) {
        getHibernateTemplate().update(account);
    }

    @Transactional
    @Override
    public void delete(Account accoount) {
        getHibernateTemplate().delete(accoount);
    }

    @Transactional
    @Override
    public Account findByName(String login) {
        List list = getHibernateTemplate().find(
                "from ACCOUNT where login=?", login
        );
        return (Account) list.get(0);
    }

}
