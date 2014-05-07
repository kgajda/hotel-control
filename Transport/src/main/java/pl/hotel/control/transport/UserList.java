/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.transport;

import java.util.List;

/**
 *
 * @author karol
 */
public class UserList {
    
    private List<User> userList;

    public UserList() {
    }

    public UserList(List<User> userList) {
        this.userList = userList;
    }
    public void add(User u){
        userList.add(u);
    }
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
}
