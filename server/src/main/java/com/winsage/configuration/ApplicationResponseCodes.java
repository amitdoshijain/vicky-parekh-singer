package com.winsage.configuration;

public enum ApplicationResponseCodes {
	
	
	INTERNAL_SERVER_ERROR(500,"internal.server.error"),
	STATUS_OK(200,"response.ok"),	
	MESSAGE_INVALID_Book_ID(400, "messge.invalid.book.id"),
	ENTITY_CREATED(201, "message.entity.created"),
	DB_ERROR(500, "message.db.error"),
	INVALID_SESSION(401, "invalid.user.session"),
	INVALID_USER(401, "invalid.user");
	
	
	private final String messageKey;

	private ApplicationResponseCodes(final Integer code,final String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return this.messageKey;
	}
}
