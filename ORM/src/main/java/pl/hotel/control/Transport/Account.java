/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * ORM - Obsłyga tabeli ACCOUNT
 *
 * @author karol
 */

public class Account implements Serializable {

   
    private Integer id;
    private String login;
    private String password;
    private String email;
    private boolean active;
    private Integer userInfo;
    private Set<Integer> stockDailyRecords = new HashSet<>(0);

    public Account() {
    }

    public Account(String login, String password, String email, boolean active) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Integer userInfo) {
        this.userInfo = userInfo;
    }

    public Set<Integer> getStockDailyRecords() {
        return stockDailyRecords;
    }

    public void setStockDailyRecords(Set<Integer> stockDailyRecords) {
        this.stockDailyRecords = stockDailyRecords;
    }

}
