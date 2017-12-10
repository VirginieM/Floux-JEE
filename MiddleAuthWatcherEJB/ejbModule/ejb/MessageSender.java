package ejb;


import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;

import dao.UserModel;

@Stateless
@LocalBean
public class MessageSender implements MessageSenderLocal {
	 
	@Inject
	JMSContext context;
	 
	@Resource(mappedName = "java:/jms/watcherAuthJMS") 
	Topic topic;
	 
	public void sendMessage(String message) {	
		TextMessage txtMsg = context.createTextMessage(message);
		JMSProducer producer = context.createProducer();
		producer.send(topic, txtMsg);
	}

	public void sendMessage(UserModel user) {
		JMSProducer producer = context.createProducer();
		producer.send(topic, user);
		System.out.println("Message envoyé dans le topic");
	}

}
