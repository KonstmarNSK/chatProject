package com.kostya.chatProject.repositories.implementations;

import com.kostya.chatProject.entities.User;
import com.kostya.chatProject.repositories.interfaces.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Костя on 15.07.2017.
 */
@Repository
public class UserRepositoryImplementation implements UserRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, new Long(id));
        return user;
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query getUserQuery = session.createQuery("from User U where U.login=:username");
        getUserQuery.setParameter("username", username);

        return (User)getUserQuery.getSingleResult();
    }
}
