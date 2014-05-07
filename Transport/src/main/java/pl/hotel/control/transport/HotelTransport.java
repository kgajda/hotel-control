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
public class HotelTransport {
    private String name;
    private String city;
    private List<RoomsTransport> rooms;

    public HotelTransport() {
    }

    public HotelTransport(String name, String city, List<RoomsTransport> rooms) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<RoomsTransport> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomsTransport> rooms) {
        this.rooms = rooms;
    }
    
    
}
