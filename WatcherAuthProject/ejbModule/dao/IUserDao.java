package dao;

import javax.ejb.Local;

import dto.UserResponse;

@Local
public interface IUserDao {
	UserModel checkUser(UserModel u);
}
