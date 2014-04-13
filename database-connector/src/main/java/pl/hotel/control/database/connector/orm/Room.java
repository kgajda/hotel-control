/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.orm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "ROOM")
public class Room implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ROOM_ID")
    private int id;
    
    @Column(name = "Stars")
    private int stars;
    @Column(name = "BED")
    private int bed;
    @Column(name = "NUMBER")
    private int number;

    public Room() {
    }

    public Room( int stars, int bed, int number) {
        this.stars = stars;
        this.bed = bed;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
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
    
    
    
    
    
}
