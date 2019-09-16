package com.dataeconomy.framework.errorHandler;

/**
 * 
 * @author Guvala
 *
 */
public class BaseAppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String DEFAULT_ERROR_ID = "DEFAULT_ERROR_MESSAGE";
	protected static final String MESSAGE_UNDEFINED = "MESSAGE_UNDEFINED";
	protected static final String DEFAULT_MESSAGE_TEXT = "The message is not defined. Please contact ICL";
	protected String messageId;
	protected String messageText;
	protected String severity;
	protected Throwable throwable;
	protected Object[] messageTextParams;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public Object[] getMessageTextParams() {
		return messageTextParams;
	}

	public void setMessageTextParams(Object[] messageTextParams) {
		this.messageTextParams = messageTextParams;
	}

	public BaseAppException() {
	}

	/**
	 * Create a new instance of BaseAppException
	 * 
	 * @param messageId
	 * @param messageTextParams
	 */
	public BaseAppException(final String messageId, final Object... messageTextParams) {
		setMessageId(messageId);
		setMessageTextParams(messageTextParams);
	}

	/**
	 * Create a new instance of BaseAppException
	 * 
	 * @param throwable
	 */
	public BaseAppException(final Throwable throwable) {
		super(throwable);
	}

	@Override
	public String getMessage() {
		return toString();
	}

}
