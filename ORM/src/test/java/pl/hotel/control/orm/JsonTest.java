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
//        hotel.getRoom().add(room3);
//        hotel.getRoom().add(room1);
//        hotel.getRoom().add(room2);
        System.out.println("###########HOTEL#############");
        String result = mapper.writeValueAsString(hotel);
        System.out.println(result);
    }

    @Test
    public void testAccount() throws IOException {
        Account account = new Account("karol", "test", "karol@agh", true);
        UserInfo info = new UserInfo("karol", "gajda", "Karoków, al Mod", "user", 123456789);
        account.setUserInfo(info);
        System.out.println("###########Account#############");
        String result = mapper.writeValueAsString(account);
        System.out.println(result);
    }

}
