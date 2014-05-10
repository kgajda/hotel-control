/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 1:n ROOMNUMBER 1:n Hotel
 *
 * @author karol
 */
@Entity
@Table(name = "HOTEL_ROOM")
public class HottelRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOTEL_ROOM_ID")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOM_NUMBER_ID")
    private NumberRoom number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @OneToMany(mappedBy = "hottelroom", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public HottelRoom() {
    }

    public HottelRoom(NumberRoom number, Hotel hotel) {
        this.number = number;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NumberRoom getNumber() {
        return number;
    }

    public void setNumber(NumberRoom number) {
        this.number = number;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

   

}
