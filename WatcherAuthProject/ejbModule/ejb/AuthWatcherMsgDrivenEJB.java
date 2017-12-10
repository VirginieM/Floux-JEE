package ejb;

import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import dao.IUserDao;
import dao.Role;
import dao.UserDao;
import dao.UserModel;
import dto.UserAuth;
import dto.UserResponse;
import model.DataContainer;

@MessageDriven(activationConfig = {@ActivationConfigProperty(
        propertyName = "destinationType",
        propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "java:/jms/watcherAuthJMS"
        )
})
public class AuthWatcherMsgDrivenEJB implements MessageListener{
	private DataContainer dataContainer;

    @Inject
    private IUserDao userDao;
    
    @EJB
    MessageSenderQueueLocal sender;

    public AuthWatcherMsgDrivenEJB() {
        dataContainer = new DataContainer();
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                System.out.println("Topic text message recieved at" + new Date());
                TextMessage msg = (TextMessage) message;
                System.out.println("Messge is :" + msg.getText());
            } else if (message instanceof ObjectMessage) {
                System.out.println("Topic obj message recieved at" + new Date());
                ObjectMessage msg = (ObjectMessage) message;
                if (msg.getObject() instanceof UserModel) {
                    UserModel user = (UserModel) msg.getObject();
                    System.out.println("User Details: ");
                    System.out.println("login:" + user.getLogin());

                    UserModel userAuth = userDao.checkUser(user);
              
                    sender.sendMessage(userAuth);
                }
            } else {
                System.out.println("Not valid message for this Queue MDB");
            }
        } catch (JMSException e) {
            e.printStackTrace();
       }

    }

}
