/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.emailsender.JmsListener;

import java.util.Map;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.hotel.control.Transport.Email;
import pl.hotel.control.emailsender.sender.Task;

/**
 *
 * @author karol
 */
public class EmailListener implements MessageListener {

    @Autowired
    private ApplicationContext ac;
    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Override
    public void onMessage(Message message) {
        Task t = ac.getBean(Task.class);
        Email e = new Email("ppp", "ppp");
        t.setEmail(e);
        executor.execute(t);
       
    }
}
