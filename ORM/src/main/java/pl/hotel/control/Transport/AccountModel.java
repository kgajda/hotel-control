/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.Transport;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import pl.hotel.control.orm.Role;
import pl.hotel.control.orm.Status;

/**
 * ORM - Obsłyga tabeli ACCOUNT 1:1 UserInfo 1:N Reservation
 *
 * @author karol
 */
public class AccountModel {

    private Integer id;
    /**
     * Login
     */
    private String login;
    /**
     * Hasło TODO: Zdobić w Hash
     */
    private String password;
    /**
     * Email uzytkownika
     */
    private String email;
    /**
     * Czy konto jest aktywne czy zablokowane
     */
    private Status status;
    /**
     * Typ użytkownika
     */
    private Role role_account;
    /**
     * Id user info
     */
    private Integer userInfoID;
    /**
     * user info
     */
    private UserInfoModel userInfo;
    /**
     * Lista Id do rezerwacji
     */
    private List<Integer> reservations = new LinkedList<>();

    public AccountModel() {
    }

    public AccountModel(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public AccountModel(Integer id, String login, String password, String email, Status status, Role role_account, Integer userInfo) {
        this(login, password, email);
        this.id = id;
        this.status = status;
        this.role_account = role_account;
        this.userInfoID = userInfoID;
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

    public Role getRole_account() {
        return role_account;
    }

    public void setRole_account(Role role_account) {
        this.role_account = role_account;
    }

    public Integer getUserInfoID() {
        return userInfoID;
    }

    public void setUserInfoID(Integer userInfoID) {
        this.userInfoID = userInfoID;
    }

    public UserInfoModel getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoModel userInfo) {
        this.userInfo = userInfo;
    }

   
    public List<Integer> getReservations() {
        return reservations;
    }

    public void setReservations(List<Integer> reservations) {
        this.reservations = reservations;
    }

}
