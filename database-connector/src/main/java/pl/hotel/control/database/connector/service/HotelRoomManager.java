/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.hotel.control.database.connector.doa.HotelRoomDOA;
import pl.hotel.control.database.connector.doa.RoomDOA;
import pl.hotel.control.orm.HotelRoom;
import pl.hotel.control.orm.Reservation;
import pl.hotel.control.orm.Room;

/**
 *
 * @author karol
 */
@Service
public class HotelRoomManager {

    @Autowired
    private HotelRoomDOA roomDOA;
    @Autowired
    private ReservationManager reservationManager;

    @Transactional
    public void save(HotelRoom r) {
        for (Reservation reservation : r.getReservations()) {
            reservation.setHottelroom(r);
            reservationManager.save(reservation);
        }
        roomDOA.save(r);
    }

}
