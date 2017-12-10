package service;

import javax.ejb.EJB;
import javax.ejb.Local;
import dao.UserModel;
import dto.UserAuth;
import ejb.MessageReceiverSyncLocal;
import ejb.MessageSenderLocal;

@Local
public class WatcherAuthService implements IWatcherAuthService {

	 	@EJB
	    MessageReceiverSyncLocal receiverSyncLocal;
	 	
	    @EJB
	    MessageSenderLocal messageSenderLocal;

	    @Override
	    public UserModel authUser(UserAuth userAuth) {
	    		String login = userAuth.getLogin();
	    		String pwd = userAuth.getMdp();
	        UserModel user = new UserModel(login, false, null);
	        if (login != null && pwd != "" && login != "" && pwd != null) {
	            messageSenderLocal.sendMessage(user);
	            user = receiverSyncLocal.receiveMessage();
	            if (user.getRole() != null) {
	                user.setRole(user.getRole());
	                user.setValidAuth(true);
	            }
	        }
	        System.out.println(user);
	        return user;
	    }
}
