/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector;

import java.sql.Date;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.hotel.control.database.connector.doa.AccountBo;
import pl.hotel.control.database.connector.doa.AccountDOA;
import pl.hotel.control.database.connector.doa.AccountDOAImpl;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.Hotel;
import pl.hotel.control.database.connector.orm.Reservation;
import pl.hotel.control.database.connector.orm.UserInfo;

/**
 * Klasa tylko do celów testowych
 *
 * @author karol
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountBo accountDOA = ac.getBean(AccountBo.class);
        Account a = new Account("sds", "sd", "sdds", true);
        a.setUserInfo(new UserInfo("asd", "sad", "asd", 1, 1));
        Reservation r = new Reservation( new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
//        r.getHotels().add(new Hotel("kraków"));
        a.getStockDailyRecords().add(r);
        accountDOA.save(a);
//        SessionFactory s = ac.getBean(SessionFactory.class);
    }
}
