/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage.controllers.model;

/**
 *
 * @author karol
 */
public class RegisterModel {

    private String login;
    private String password1;
    private String password2;
    private String name;
    private String sourname;
    private String addres;
    private String mail;
    private int phone;

    public RegisterModel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourname() {
        return sourname;
    }

    public void setSourname(String sourname) {
        this.sourname = sourname;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        builder.append("Name: ").append(name).append("");
        builder.append("Sourname: ").append(sourname);
        builder.append("Password: ********");
        builder.append("Login: ").append(login).append(" ");
        builder.append("Address: ").append(addres).append(" ");
        builder.append("Email: ").append(mail);
        builder.append("Phone: ").append(phone);
        return builder.toString();
    }
    
    

}
