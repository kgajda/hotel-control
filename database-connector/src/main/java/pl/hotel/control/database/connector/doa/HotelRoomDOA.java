/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import pl.hotel.control.orm.HotelRoom;

/**
 *
 * @author karol
 */
public interface HotelRoomDOA {
   /**
    * Zapis nowego pokoju
    * @param hotelRoom 
    */
   void save(HotelRoom hotelRoom);
}
