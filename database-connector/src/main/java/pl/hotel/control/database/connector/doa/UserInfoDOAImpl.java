/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karol
 */
@Repository
public class UserInfoDOAImpl extends CustomHibernateDaoSupport implements UserInfo {

    @Transactional
    @Override
    public void save(pl.hotel.control.orm.UserInfo info) {
        getSessionFactory().getCurrentSession().save(info);
    }

}
