package ejb;

import javax.ejb.Local;

import dao.UserModel;

@Local
public interface MessageReceiverSyncLocal {
	
	public UserModel receiveMessage();

}
