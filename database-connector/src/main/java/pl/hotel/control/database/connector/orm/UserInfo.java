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
    private int id;
    @Column(name = "NAME", length = 20, nullable = false)
    private String name;
    @Column(name = "SOUR_NAME", length = 20, nullable = false)
    private String sourName;
    @Column(name = "ADRESS", length = 50, nullable = false)
    private String adress;
    @Column(name = "ROLE", length = 1, nullable = false)
    private int role;
    @Column(name = "PHONE", length = 9, nullable = false)
    private int phone;

    public UserInfo() {
    }

    public UserInfo(String name, String sourName, String adress, int role, int phone) {
        this.name = name;
        this.sourName = sourName;
        this.adress = adress;
        this.role = role;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
