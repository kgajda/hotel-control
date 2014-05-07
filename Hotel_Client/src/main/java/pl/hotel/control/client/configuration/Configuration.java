/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.client.configuration;

import org.springframework.stereotype.Component;

/**
 *
 * @author karol
 */
@Component
public class Configuration {
    private ClientConfig clientConfig;

    public Configuration() {
        clientConfig = new ClientConfig("http://localhost:8084/Hotel-WebPage/");
    }
    
    
    
    public synchronized void update(ClientConfig clientConfig){
        this.clientConfig = clientConfig;
    }
    
    public synchronized ClientConfig getConfiguration(){
        return clientConfig;
    }
}
