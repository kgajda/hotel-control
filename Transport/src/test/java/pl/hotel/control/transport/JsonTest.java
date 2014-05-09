/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.transport;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author karol
 */
public class JsonTest {

    private ObjectMapper objectMapper;

    public JsonTest() {
        objectMapper = new ObjectMapper();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hotelTransportTest() throws IOException {
        HotelTransport hotelTransport = new HotelTransport();
        hotelTransport.setCity("Karaków");
        hotelTransport.setName("Jedynka");
        List<RoomsTransport> roomsTransports = new LinkedList<>();
        roomsTransports.add(new RoomsTransport(5, 2, 1));
        roomsTransports.add(new RoomsTransport(5, 2, 2));
        roomsTransports.add(new RoomsTransport(5, 2, 3));
        roomsTransports.add(new RoomsTransport(5, 1, 4));
        roomsTransports.add(new RoomsTransport(5, 1, 5));
        roomsTransports.add(new RoomsTransport(5, 5, 6));
        hotelTransport.setRooms(roomsTransports);
        String result = objectMapper.writeValueAsString(hotelTransport);
        System.out.println("######################################");
        System.out.println("Hotel: " + result);

        HotelTransport jsonConvert = objectMapper.readValue(result, HotelTransport.class);
        assertEquals(hotelTransport.getCity(), jsonConvert.getCity());
    }

    @Test
    public void reTest() throws IOException {
        RegisterModel model = new RegisterModel();
        model.setAdress("Kraków, ul Młyńska 53/3");
        model.setEmail("karol@agh");
        model.setLogin("karol");
        model.setName("karol");
        model.setPassword("123");
        model.setPhone(123456789);
        model.setSourName("Gajda");
        String result = objectMapper.writeValueAsString(model);
        System.out.println("######################################");
        System.out.println("Hotel: " + result);
    }

}
