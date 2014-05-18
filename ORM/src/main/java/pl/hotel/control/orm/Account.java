/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.orm;

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
 * ORM - Obsłyga tabeli ACCOUNT 1:1 UserInfo 1:N Reservation
 *
 * @author karol
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Integer id;
    /**
     * Login
     */
    @Column(name = "LOGIN")
    private String login;
    /**
     * Hasło TODO: Zdobić w Hash
     */
    @Column(name = "PASSWORD")
    private String password;
    /**
     * Email uzytkownika
     */
    @Column(name = "EMAIL")
    private String email;
    /**
     * Czy konto jest aktywne czy zablokowane
     */
    @Column(name = "STATUS")
    private Status status;
    @Column(name = "ROLE_ACCOUNT")
    private Role role_account;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserInfo userInfo = new UserInfo();
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>(0);

    public Account() {
    }

    public Account(String login, String password, String email, Status status, Role role_account) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.status = status;
        this.role_account = role_account;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Set<Reservation> getStockDailyRecords() {
        return reservations;
    }

    public void setStockDailyRecords(Set<Reservation> stockDailyRecords) {
        this.reservations = stockDailyRecords;
    }

    public Role getRole_account() {
        return role_account;
    }

    public void setRole_account(Role role_account) {
        this.role_account = role_account;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: " + id);
        builder.append("Login: " + login);
        if (userInfo != null) {
            builder.append("UserInfo: ");
            builder.append(userInfo.toString());
        }
        return builder.toString();
    }

}
