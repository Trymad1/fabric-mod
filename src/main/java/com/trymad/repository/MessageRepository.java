package com.trymad.repository;

import com.trymad.model.MessageEntity;

public interface MessageRepository {
	
	MessageEntity save(MessageEntity message);

}
