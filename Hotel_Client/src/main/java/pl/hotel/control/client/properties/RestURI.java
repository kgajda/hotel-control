/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.properties;

/**
 *
 * @author karol
 */
public class RestURI {

    public static final String ROOT_URI = "http://localhost:8084/serwer";
    public static final String REGISTRATION_URI = ROOT_URI + "/registion";
    public static final String ADMIN_USERS_URI = ROOT_URI + "/admin/user";
    public static final String ADMIN_HOTEL_URI = ROOT_URI + "/admin/hotel";
    public static final String HOTELS_URI = ROOT_URI + "/hotel";

    public static String getUser(String user) {
        return ADMIN_USERS_URI + "/" + user;
    }

}
