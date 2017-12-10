package ejb;

import javax.ejb.Local;

import dao.UserModel;

@Local
public interface MessageSenderQueueLocal {
	
	public void sendMessage(String message);
	public void sendMessage(UserModel user);
	
}
