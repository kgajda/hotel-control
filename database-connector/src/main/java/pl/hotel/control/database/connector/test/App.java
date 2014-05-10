/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.hotel.control.database.connector.SpringConfigDb;
import pl.hotel.control.orm.Hotel;
import pl.hotel.control.orm.Room;
import pl.hotel.control.database.connector.service.HotelManager;
import pl.hotel.control.database.connector.service.RoomManager;

/**
 * Wyłącznie do testów
 * @author karol
 */
public class App {
    
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigDb.class);
        
    }
    
}
