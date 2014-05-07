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
public class RegisterModel {
    
    private String login;
    private String password;
    private String email;
    private String name;
    private String sourName;
    private String adress;
    private int phone;

    public RegisterModel() {
    }

    public RegisterModel(String login, String password, String email, String name, String sourName, String adress, int phone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.sourName = sourName;
        this.adress = adress;
        this.phone = phone;
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
    
    
    
}
