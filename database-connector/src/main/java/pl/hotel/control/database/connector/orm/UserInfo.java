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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
