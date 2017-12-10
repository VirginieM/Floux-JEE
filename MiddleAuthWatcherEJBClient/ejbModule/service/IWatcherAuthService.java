package service;

import javax.ejb.Local;

import dao.UserModel;
import dto.UserAuth;

@Local
public interface IWatcherAuthService {
	UserModel authUser(UserAuth user);
}
