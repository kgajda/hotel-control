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
 * ORM - Obsłyga tabeli ACCOUNT
 *
 * @author karol
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ACCOUNT_ID")
    private int id;
    @Column(name = "LOGIN", length = 30, nullable = false)
    private String login;
    @Column(name = "PASSWORD", length = 30, nullable = false)
    private String password;
    @Column(name = "EMAIL", length = 30, nullable = false)
    private String email;
    @Column(name = "ACTIVE", length = 1, nullable = false)
    private boolean active;

    public Account() {
    }

    public Account(String login, String password, String email, boolean active) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
