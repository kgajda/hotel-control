/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.client.properties;

import java.util.LinkedHashMap;
import java.util.Map;
import pl.hotel.control.orm.Role;
import pl.hotel.control.orm.Status;

/**
 *
 * @author karol
 */
public class Properties {

    public static Map getStatus() {
        Map<String, String> strausMap = new LinkedHashMap();
        for (Status status : Status.values()) {
            strausMap.put(status.name(), status.name());
        }
        return strausMap;
    }

    public static Map getRole() {
        Map<String, String> strausMap = new LinkedHashMap();
        for (Role status : Role.values()) {
            strausMap.put(status.name(), status.name());
        }
        return strausMap;
    }

}
