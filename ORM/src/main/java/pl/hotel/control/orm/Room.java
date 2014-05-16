/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
 *
 * @author karol
 */
@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID", nullable = false, unique = true)
    private int id;

    
    @Column(name = "BED")
    private int bed;
    @Column(name = "NUMBER")
    private int number;
    
    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    private Set<HotelRoom> hotelRooms = new HashSet<>();

    public Room() {
    }

    public Room( int bed, int number) {
        this.bed = bed;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(Set<HotelRoom> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

}
