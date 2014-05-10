/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author karol
 */

public class Reservation implements Serializable {

    
    private int id;


    private Date date_from;

    private Date date_to;
    
    private Integer account;

    private Set<Integer> rooms = new HashSet<>();

    public Reservation() {
    }

    public Reservation(Date date_from, Date date_to) {
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
