/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.transport;

import java.util.List;

/**
 *
 * @author karol
 */
public class HotelsTransport {
    
    List<HotelTransport> hotels;

    public HotelsTransport() {
    }

    public HotelsTransport(List<HotelTransport> hotels) {
        this.hotels = hotels;
    }

    public List<HotelTransport> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelTransport> hotels) {
        this.hotels = hotels;
    }
    
    
}
