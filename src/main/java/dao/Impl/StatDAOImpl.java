package dao.Impl;

import dao.interfeses.StatDAO;
import entity.Stat;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class StatDAOImpl implements StatDAO {
    /**
     * @param email User
     * @return object Stat
     */
    @Override
    public Stat getByUser(String email) {
         try(SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             Query<Stat> query = session.createQuery(
                     "from Stat where user.email like :email", Stat.class);
             query.setParameter("email", email);
             return query.uniqueResult();
         }
    }

    /**
     * @param user, in the method parameter, we pass User
     * @return the method returns the Stat object passed to the User object parameter
     */
    @Override
    public Stat getByUser(User user) {
        try(SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            Query<Stat> query = session.createQuery(
                    "from Stat where user.email like :email", Stat.class);
            query.setParameter("email", user.getEmail());
            return query.uniqueResult();
        }
    }
}
