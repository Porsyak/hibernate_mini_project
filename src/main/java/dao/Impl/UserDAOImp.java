package dao.Impl;

import dao.CommonDAO;
import dao.FindDAO;
import dao.interfeses.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImp implements UserDAO {

    @Override
    public List<User> findAll() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            return session.createQuery("from User", User.class).getResultList();
        }
    }

    @Override
    public List<User> findAll(String email) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where email =: email", User.class);
            query.setParameter("email", email);
            return query.getResultList();
        }

    }

    @Override
    public User get(long id) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void upData(User obj) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.merge(obj);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(long id) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            User user = session.get(User.class, id);
//            User user = new User(); --- так не работает
//            user.setId(id);
            session.remove(user);
            session.getTransaction().commit();

        }
    }

    @Override
    public void add(User obj) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(obj);
            session.getTransaction().commit();
        }
    }

    @Override
    public User getByEmail(String emailUser) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(
                    "from User where email like :email", User.class);
            query.setParameter("email", emailUser);
            return query.uniqueResult();

        }
    }
}
