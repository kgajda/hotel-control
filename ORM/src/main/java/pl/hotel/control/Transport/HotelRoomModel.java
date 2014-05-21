/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import java.util.LinkedList;
import java.util.List;

/**
 * 1:n ROOMNUMBER 1:n Hotel
 *
 * @author karol
 */
public class HotelRoomModel {

    private Integer id;
    private Integer number;
    private RoomModel room;
    private Integer stars;
    private List<Integer> reservations = new LinkedList<>();

    public HotelRoomModel() {
    }

    public HotelRoomModel(Integer number, RoomModel room) {
        this.number = number;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public pl.hotel.control.Transport.RoomModel getRoom() {
        return room;
    }

    public void setRoom(pl.hotel.control.Transport.RoomModel room) {
        this.room = room;
    }

    public List<Integer> getReservations() {
        return reservations;
    }

    public void setReservations(List<Integer> reservations) {
        this.reservations = reservations;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

}
