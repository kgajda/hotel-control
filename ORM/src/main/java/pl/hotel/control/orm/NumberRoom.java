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
import javax.persistence.Table;

/**
 * 1:n hottelroom n:1 reservation
 *
 * @author karol
 */
@Entity
@Table(name = "NUMBER_ROOM")
public class NumberRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMBER_ROOM_ID")
    private Integer id;

    @Column(name = "NUMBER_ROOM")
    private String numberRoom;
    @OneToMany(mappedBy = "number", fetch = FetchType.EAGER)
    private Set<HotelRoom> hotelRooms = new HashSet<>();

    public NumberRoom() {
    }

    public NumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    public Set<HotelRoom> getHottelRooms() {
        return hotelRooms;
    }

    public void setHottelRooms(Set<HotelRoom> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
