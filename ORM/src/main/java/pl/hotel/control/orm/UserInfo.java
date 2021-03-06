/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.orm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author karol
 */
@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_INFO_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SOUR_NAME")
    private String sourName;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "PHONE")
    private int phone;

    public UserInfo() {
    }

    public UserInfo(String name, String sourName, String adress, int phone) {
        this.name = name;
        this.sourName = sourName;
        this.adress = adress;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: " + id);
        builder.append("Name: " + name);
        builder.append("Sourname: " + sourName);
        builder.append("Address: " + adress);
        return builder.toString();
    }

}
