/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import java.util.List;
import pl.hotel.control.database.connector.orm.Account;
import pl.hotel.control.database.connector.orm.Hotel;

/**
 *
 * @author karol
 */
public interface HotelDOA {

    void save(Hotel hotel);

    void update(Hotel hotel);

    void delete(Hotel hotel);

    Account findByName(String name);
    List<Hotel> getAllHotels();

}
