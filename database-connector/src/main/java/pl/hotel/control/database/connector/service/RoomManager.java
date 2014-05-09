/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hotel.control.database.connector.doa.RoomDOA;
import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
@Service
public class RoomManager {
    
    @Autowired
    private RoomDOA roomDOA;

   public void save(Room r){
       roomDOA.save(r);
   }
    
    
    
    
    
}
