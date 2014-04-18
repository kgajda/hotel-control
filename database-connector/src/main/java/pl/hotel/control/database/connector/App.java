/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector;

import java.sql.Date;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.hotel.control.database.connector.doa.AccountDOA;
import pl.hotel.control.database.connector.doa.AccountDOAImpl;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.Hotel;
import pl.hotel.control.database.connector.orm.Reservation;
import pl.hotel.control.database.connector.orm.Room;
import pl.hotel.control.database.connector.orm.UserInfo;
import pl.hotel.control.database.connector.service.AccountManager;

/**
 * Klasa tylko do celów testowych
 *
 * @author karol
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountManager accountDOA = ac.getBean(AccountManager.class);
        accountDOA.save(test());
    }

    public static Account test() {
        Account account = new Account("login", "hasło", "asd", true);
        account.setUserInfo(new UserInfo("name", "name", "dsaads", 1, 123456798));
        Set<Reservation> r = account.getStockDailyRecords();
        Reservation ra = new Reservation(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        Set<Hotel> h = ra.getHotels();
        h.add(new Hotel("kraków"));
        Hotel ha = new Hotel("Warszawa");
        ha.getRoom().add(new Room(2, 2, 2));
        ha.getRoom().add(new Room(2, 2, 2));
        ha.getRoom().add(new Room(2, 2, 2));
        h.add(ha);
        r.add(ra);

        return account;
    }
}
