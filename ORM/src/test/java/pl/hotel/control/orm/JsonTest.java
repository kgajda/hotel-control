/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.orm;

import java.io.IOException;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karol
 */
public class JsonTest {
    private ObjectMapper mapper;
    public JsonTest() {
        mapper = new ObjectMapper();
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

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testHottel() throws IOException {
        Hotel hotel = new Hotel();
        hotel.setCity("Kraków");
        hotel.setName("Jedynka");
        Room room1 = new Room(4, 1, 1);
        Room room2 = new Room(4, 1, 2);
        Room room3 = new Room(4, 1, 3);
        room1.setHotel(hotel);
        room2.setHotel(hotel);
        room3.setHotel(hotel);
        hotel.getRoom().add(room3);
        hotel.getRoom().add(room1);
        hotel.getRoom().add(room2);
        System.out.println("###########HOTEL#############");
        String result = mapper.writeValueAsString(hotel);
        System.out.println(result);
    }

   
    
}
