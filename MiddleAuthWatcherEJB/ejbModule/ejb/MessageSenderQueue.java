package ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import dao.UserModel;


/**
* Session Bean implementation class MessageSenderQueue
*/
@Stateless
@LocalBean
public class MessageSenderQueue implements MessageSenderQueueLocal{
	 
	@Inject
	JMSContext context;
	 
	@Resource(mappedName = "java:/jms/queue/watcherqueue")
	Queue queue;
	 
	
	@Override
	public void sendMessage(String message) {
		context.createProducer().send(queue, message);	 
	}

	@Override
	public void sendMessage(UserModel user) {
		try {
			ObjectMessage message = context.createObjectMessage();
			message.setObject(user);
			context.createProducer().send(queue, user);
			System.out.println("message sent");
			} catch (JMSException e) {
				e.printStackTrace();
			}	
	}

}
