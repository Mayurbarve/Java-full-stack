package SocialMedia.com.socialPlatform;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}