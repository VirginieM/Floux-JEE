package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dto.UserResponse;

@Stateless
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserModel checkUser(UserModel user) {
    		UserModel u = new UserModel();
        try {
        		u = (UserModel) entityManager.createQuery("from UserModel u where u.login = :login AND u.pwd = :pwd")
                    .setParameter("login", u.getLogin())
                    .setParameter("pwd", u.getPwd())
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        user.setFirstName("User");
        user.setLastName("Test");
        user.setValidAuth(true);
        user.setRole(Role.ADMIN);
        return user;
    }
}
