/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.doa.ReservationDOA;
import pl.hotel.control.database.connector.doa.ReservationDOAImpl;
import pl.hotel.control.orm.Reservation;

/**
 *
 * @author karol
 */
@Service
public class ReservationManager {
    
     private final static Logger LOGGER = Logger.getLogger(AccountManager.class);
     
     @Autowired
     private HotelManager manager;
     @Autowired
     private AccountManager accountManager;
     @Autowired
     private ReservationDOA reservationDOA; 
     
     @Transactional
     public void save(Reservation r){
         reservationDOA.save(r);
     }
     
    
}
