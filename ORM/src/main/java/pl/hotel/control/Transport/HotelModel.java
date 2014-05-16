/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import pl.hotel.control.orm.*;
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
 * 1:n NumberROOM
 *
 * @author karol
 */
@Entity
@Table(name = "HOTEL")
public class HotelModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOTEL_ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "Stars")
    private int stars;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HotelRoomModel> room = new HashSet<>();

    public HotelModel() {
    }

    public HotelModel(String name, String city, int stars) {
        this.name = name;
        this.city = city;
        this.stars = stars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<HotelRoomModel> getRoom() {
        return room;
    }

    public void setRoom(Set<HotelRoomModel> room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: " + id);
        builder.append("Name: " + name);
        builder.append("City: " + city);
        builder.append("Stars: "+ stars);
        builder.append("Ilość pokoi" + Integer.toString(room.size()));
        return builder.toString();
    }

}
