/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.transport;

/**
 *
 * @author karol
 */
public class User {
    private String login;
    private String name;
    private String surname;
    private int phone;
    private String adress;
    private boolean active;

    public User() {
    }

    public User(String login, String name, String surname, int phone, String adress, boolean active) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

   
    
    
    
}
