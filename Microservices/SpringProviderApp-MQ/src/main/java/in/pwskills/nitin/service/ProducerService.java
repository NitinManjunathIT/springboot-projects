package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate jmt;
	
	@Value("${my.app.desti-name}")
	private String destination;
	
	public void sendData(String message) {
		//Message createMessage(Session session) throws JMSException
		jmt.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				System.out.println("Session :: "+session.getClass().getName());
				System.out.println("Message :: "+message.getClass().getName());
				return textMessage;
			}
		});
	}
	
}
