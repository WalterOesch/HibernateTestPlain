package ch.oesch;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// JPA
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Walter Oesch on 14.05.2017.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static EntityManagerFactory entityManagerFactory = null;
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

    // JPA
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory ==  null) {
            // JPA
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("Sample");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entityManagerFactory;
    }
}
