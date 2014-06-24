package com.beautyProj.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.beautyProj.model.Pager;
import com.beautyProj.model.SystemContext;
import com.beautyProj.model.User;
@Repository("userDao")
public class UserDao {
    @Resource
    private SessionFactory sessionFactory;

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(int id) {
        User user = getUser(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public User getUser(int id) {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);

    }

    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = ?").setParameter(0, username);
        return (User) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        String hql = "from User";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public Pager<User> find() {
        int size = SystemContext.getSize();
        int offset = SystemContext.getOffset();
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        query.setFirstResult(offset).setMaxResults(size);
        List<User> datas = query.list();
        long total = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from User").uniqueResult();
        Pager<User> us = new Pager<User>();
        us.setDatas(datas);
        us.setOffset(offset);
        us.setSize(size);
        us.setTotal(total);
        return us;
    }
}
