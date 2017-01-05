package com.winsage.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component("localeMessageReader")
public class LocaleMessageReader implements MessageSourceAware {

	@Autowired
	private MessageSource messageSource;
	@Override
	public void setMessageSource(MessageSource messageSource) {
		// TODO Auto-generated method stub		
		this.messageSource = messageSource;		
	}
	
	public String getMessage(final String messageKey){		
		final String message = this.messageSource.getMessage(messageKey, null, Locale.US);
		return message;
	}
	
	
	

}
