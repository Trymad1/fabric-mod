package com.trymad.service;

import java.util.UUID;

import com.trymad.model.MessageEntity;
import com.trymad.model.MessageProto.Message;
import com.trymad.repository.HibernateMessageRepository;
import com.trymad.repository.MessageRepository;

public class MessageService {

	private static MessageService instance;

    private final MessageRepository messageRepository;

    public static MessageService getInstance() {
        if (instance == null) {
            synchronized (MessageService.class) {
                if (instance == null) {
                    instance = new MessageService(new HibernateMessageRepository());
                }
            }
        }
        return instance;
    }
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public MessageEntity save(Message message, UUID playerId) {
		if(message.getText().isEmpty()) throw new IllegalArgumentException("Message is empty");
		final MessageEntity entity = new MessageEntity(playerId, message.getText().trim());
		return save(entity);
	}

	public MessageEntity save(MessageEntity entity) {
		return messageRepository.save(entity);
	}

}
