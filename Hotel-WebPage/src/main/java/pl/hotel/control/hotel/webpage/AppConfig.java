/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.hotel.webpage;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.hotel.control.database.connector.SpringConfigDb;

/**
 *
 * @author karol
 */
@Configuration
@Import(SpringConfigDb.class)
public class AppConfig {

}
