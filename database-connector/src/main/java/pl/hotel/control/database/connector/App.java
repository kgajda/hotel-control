/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Klasa tylko do celów testowych
 *
 * @author karol
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");

    }
}
