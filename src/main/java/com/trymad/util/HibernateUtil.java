package com.trymad.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	public static void connect() {
		
		// фейковый запрос для ленивой инициализации бд
		try (Session session = sessionFactory.openSession()) {
			session.createNativeQuery("SELECT 1", Integer.class).getSingleResult();
		}
	}
}
