package model;

import java.util.ArrayList;
import java.util.List;

import dao.Role;
import dao.UserModel;
import dto.UserAuth;

public class DataContainer {
	
    List<UserModel> userList = new ArrayList<>();

    public UserModel saveUser(UserModel user) {
        userList.add(user);
        return user;
    }

    public Role checkUser(UserAuth user) {
        Role result = null;
        for (UserModel u : userList) {
            if (u.getLogin().equals(user.getLogin())) {
                if (u.getPwd().equals(user.getMdp())) {
                    result = Role.ADMIN;
                } else {
                    result = Role.NONE;
                }
            }

        }
        return result;
    }

	public Role checkUser(UserModel user) {
		return Role.ADMIN;
	}
}
