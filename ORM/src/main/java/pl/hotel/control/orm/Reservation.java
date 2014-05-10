/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.orm;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "RESERVATIONS")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private int id;

    @Column(name = "DATE_FROM", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_from;

    @Column(name = "DATE_TO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_to;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private HottelRoom hottelroom;

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

    public HottelRoom getHottelroom() {
        return hottelroom;
    }

    public void setHottelroom(HottelRoom hottelroom) {
        this.hottelroom = hottelroom;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
