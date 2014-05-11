/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.doa;

import java.util.List;
import pl.hotel.control.orm.Account;
import pl.hotel.control.orm.Hotel;

/**
 * Dostęp do DB
 * @author karol
 */
public interface HotelDOA {

    /**
     * Zapis hotelu do db
     *
     * @param hotel
     */
    void save(Hotel hotel);

    /**
     * Zapis hotelu do db
     *
     * @param hotel
     */
    void update(Hotel hotel);

    /**
     * Usunięcie Hotelu z db
     *
     * @param hotel
     */
    void delete(Hotel hotel);

    /**
     * Wyszukiwanie Hotelu po nazwie
     *
     * @param name
     * @return
     */
    Hotel findByName(String name);

    /**
     * Listowanie hoteli
     *
     * @return
     */
    List<Hotel> getAllHotels();

}
