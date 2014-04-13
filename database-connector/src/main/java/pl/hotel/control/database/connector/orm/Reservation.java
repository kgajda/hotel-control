/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.orm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private int id;

    @Column(name = "DATE_FROM", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_from;

    @Column(name = "DATE_TO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_to;

    public Reservation() {
    }

    public Reservation(int id, Date date_from, Date date_to) {
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
