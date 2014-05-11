/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.database.connector.doa;

import org.springframework.stereotype.Repository;
import pl.hotel.control.orm.NumberRoom;

/**
 *
 * @author karol
 */
public interface NumberRoomDOA {
    void save(NumberRoom numberRoom);
}
