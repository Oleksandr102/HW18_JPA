package com.company.dao;

import com.company.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void createUser(User user) {
        getCurrentSession().persist(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        getCurrentSession().delete(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("SELECT u FROM User u").list();
    }

    @Transactional
    public User getUserById(Long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Transactional
    public void editUser(User user){
        getCurrentSession().update(user);
    }

}
