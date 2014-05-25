/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.hotel.control.jmssender.send;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import pl.hotel.control.Transport.Email;

/**
 *
 * @author karol
 */
@Component
public class JmsSenderImpl implements JmsSender{
    @Autowired
    private JmsTemplate jmsTemplate;
    private static final Logger LOGGER = Logger.getLogger(JmsSenderImpl.class);
    public void sendEmail(Email email){
        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("to", email.getTo());
                mapMessage.setString("token", email.getToken());
                return mapMessage;
            }
        });
        LOGGER.info("Send JMS Message: "+email.getTo());
    }
}
