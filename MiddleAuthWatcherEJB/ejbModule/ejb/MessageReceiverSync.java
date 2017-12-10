package ejb;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import dao.UserModel;

@Stateless
@Local
public class MessageReceiverSync implements MessageReceiverSyncLocal{	 
	
	@Inject
	private JMSContext context;
	 
	@Resource(mappedName = "java:/jms/queue/watcherqueue") 
	Queue queue;
	 
	public UserModel receiveMessage() {
		JMSConsumer consumer = context.createConsumer(queue);
		Message message = consumer.receive(1000);
		
		ObjectMessage msg = (ObjectMessage) message;
		
		UserModel user = new UserModel();
		try {
		    if( msg.getObject() instanceof UserModel){
		    		user = (UserModel)msg.getObject();
		    }
		} catch (JMSException e) {
			 e.printStackTrace();
		}
		return user;
	}
	 
}
