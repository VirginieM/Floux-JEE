package impl;

import javax.inject.Inject;

import dao.Role;
import dao.UserModel;
import dto.UserAuth;
import ejb.MessageReceiverSyncLocal;
import ejb.MessageSenderLocal;
import fr.cpe.IWatcherAuth;
import service.IWatcherAuthService;

public class WatcherAuth implements IWatcherAuth{	 

	 @Inject
	 IWatcherAuthService service;
	 
	
	public UserModel doPost(UserAuth userAuth) {
		return service.authUser(userAuth);
	}
	

}
