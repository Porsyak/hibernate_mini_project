package dao.Impl;

import dao.FindDAO;
import dao.interfeses.TaskDAO;
import entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Override
    public List<Task> findAll() {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            return session.createQuery("from Task", Task.class).getResultList();
        }
    }

    @Override
    public List<Task> findAll(String email) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Query<Task> query = session.createQuery(
                    "from Task t " +
                               "where t.user.email =: email", Task.class);
            query.setParameter("email", email);
            return query.getResultList();
        }

    }

    @Override
    public Task get(long id) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            return session.get(Task.class, id);
        }
    }

    @Override
    public void upData(Task obj) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.merge(obj);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(long id) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Task user = session.get(Task.class, id);
//            Task user = new Task(); --- так не работает
//            user.setId(id);
            session.remove(user);
            session.getTransaction().commit();

        }
    }

    @Override
    public void add(Task obj) {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(obj);
            session.getTransaction().commit();
        }
    }
    @Override
    public List<Task> find(short completed, String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Task> query = session.createQuery("from Task t " +
                "where t.user.email like :email and t.completed =: completed", Task.class);
        query.setParameter("completed", completed);
        query.setParameter("email", email);
        List<Task>list = query.getResultList();
       session.close();
       return list;
    }
}
