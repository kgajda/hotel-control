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
        HotelManager hotelManager = ac.getBean(HotelManager.class);
        RoomManager roomManager = ac.getBean(RoomManager.class);
        Hotel h = new Hotel("krakówa");
        Room r = new Room(5, 7, 1);
        h.getRoom().add(r);
        r.setHotel(h);
        
        
//        roomManager.save(r);
        hotelManager.save(h);
        List<Hotel> roms = hotelManager.getAllHotels();
        for (Hotel hotel : roms) {
            System.out.println(hotel.getCity());
            for (Room room : hotel.getRoom()) {
                System.out.println(room.getBed());
            }
        }
        
    }
    
}
