/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.transport;

/**
 *
 * @author karol
 */
public class RoomsTransport {

    private int stars;
    private int bed;
    private int number;

    public RoomsTransport() {
    }

    public RoomsTransport(int stars, int bed, int number) {
        this.stars = stars;
        this.bed = bed;
        this.number = number;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
