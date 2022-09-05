package dao.Impl;

import dao.CommonDAO;
import dao.FindDAO;
import dao.interfeses.ActivityDAO;
import entity.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ActivityDAOImpl implements ActivityDAO {
    @Override
    public Activity get(long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Activity activity = session.get(Activity.class, id);
        session.close();
        return activity;
    }

    @Override
    public void upData(Activity obj) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        throw new RuntimeException("You cant delete activity by yourself - only DB can");

    }

    @Override
    public void add(Activity obj) {
        throw new RuntimeException("You cant add activity by yourself - only DB`s trigger can");
    }


    @Override
    public Activity getByUser(String emailUser) {
        return null;
    }
}
