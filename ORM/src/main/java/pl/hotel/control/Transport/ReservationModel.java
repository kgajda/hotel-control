/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import java.util.Date;

/**
 *
 * @author karol
 */
public class ReservationModel {
/**
 * Id rezerwacji
 */
    private Integer id;
    /**
     * Od
     */
    private Date date_from;
    /**
     * Do
     */
    private Date date_to;
    /**
     * Login uzytkownika
     */
    private String login;
    /**
     * pokuj
     */
    private HotelRoomModel hotelroom;
    /**
     * Hotel
     */
    private HotelModel hotel;

    public ReservationModel() {
    }

    public ReservationModel(Integer id, Date date_from, Date date_to, String login, pl.hotel.control.Transport.HotelRoomModel hotelroom, pl.hotel.control.Transport.HotelModel hotel) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.login = login;
        this.hotelroom = hotelroom;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public pl.hotel.control.Transport.HotelRoomModel getHotelroom() {
        return hotelroom;
    }

    public void setHotelroom(pl.hotel.control.Transport.HotelRoomModel hotelroom) {
        this.hotelroom = hotelroom;
    }

    public pl.hotel.control.Transport.HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(pl.hotel.control.Transport.HotelModel hotel) {
        this.hotel = hotel;
    }


}
