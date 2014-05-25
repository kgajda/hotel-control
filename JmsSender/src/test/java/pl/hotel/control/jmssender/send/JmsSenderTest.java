/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.jmssender.send;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.hotel.control.Transport.Email;
import pl.hotel.control.jmssender.JmsSenderConfig;

/**
 *
 * @author karol
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JmsSenderConfig.class})
public class JmsSenderTest {
    @Autowired
    private JmsSender jmsSender;

    public JmsSenderTest() {
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
     * Test of sendEmail method, of class JmsSender.
     */
    @Test
    public void testSendEmail() {
        Email email = new Email("karoll.gajda@gmail.com", "Test");
        jmsSender.sendEmail(email);
    }

}
