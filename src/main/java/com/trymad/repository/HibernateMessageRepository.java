package com.trymad.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trymad.model.MessageEntity;
import com.trymad.util.HibernateUtil;

public class HibernateMessageRepository implements MessageRepository {

	@Override
	public MessageEntity save(MessageEntity message) {
		try (final Session session = HibernateUtil.getSessionFactory().openSession()) {
			final Transaction transaction = session.beginTransaction();
			
			session.persist(message);
			
			transaction.commit();
		} catch(Exception e) {
			throw e;
		}

		return message;
	}
	
}
