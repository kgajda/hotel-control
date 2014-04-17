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
    public void save(Account stock) {
        getHibernateTemplate().save(stock);
    }

    @Transactional
    @Override
    public void update(Account stock) {
        getHibernateTemplate().update(stock);
    }

    @Transactional
    @Override
    public void delete(Account stock) {
        getHibernateTemplate().delete(stock);
    }

    @Transactional
    @Override
    public Account findByStockCode(String stockCode) {
        List list = getHibernateTemplate().find(
                "from Stock where stockCode=?", stockCode
        );
        return (Account) list.get(0);
    }

}
