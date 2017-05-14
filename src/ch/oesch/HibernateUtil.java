package ch.oesch;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Walter Oesch on 14.05.2017.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration=new Configuration();
            configuration.configure();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
