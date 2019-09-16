package com.dataeconomy.framework.errorHandler;

import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dataeconomy.framework.logging.AppLogger;
import com.dataeconomy.framework.logging.Log;
import com.dataeconomy.framework.util.AppBundle;
import com.dataeconomy.framework.util.MessageJson;
import com.dataeconomy.workbench.constant.MessagesEnum;

/**
 * 
 * @author Guvvala
 *
 */
@ControllerAdvice
public class AppExceptionHandler {

	private static @Log AppLogger logger;

	@ExceptionHandler(Throwable.class)
	public @ResponseBody ResponseEntity<MessageJson> handleSQLException(Throwable th) {
		MessageJson mjson = getExceptionString(th);
		return new ResponseEntity<MessageJson>(mjson, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * handles the exception and construct the message
	 * 
	 */
	public MessageJson getExceptionString(Throwable th) {
		logger.error(th,th);
		if (th instanceof AppException) {
			AppException ke = (AppException) th;
			if (ke.isShowDetails()) {
				if (ke.getDetails() != null) {
					return new MessageJson(502, ke.getMessageText(), ke.getDetails());
				}
				return new MessageJson(502, ke.getMessageText(), getStackTrace(ke));
			}
			return new MessageJson(501, ke.getMessage());
		} else if (th instanceof PersistenceException) {
			return new MessageJson(501, AppBundle.getString(MessagesEnum.UNEXPECTEDFAILURE.getBundle(),
					MessagesEnum.UNEXPECTEDFAILURE.getKey()));
		} else if (th instanceof OptimisticLockException) {
			return new MessageJson(501,
					AppBundle.getString(MessagesEnum.CONCURRENTMSG.bundleName, MessagesEnum.CONCURRENTMSG.key));
		} else {
			return new MessageJson(501, AppBundle.getString(MessagesEnum.UNEXPECTEDFAILURE.getBundle(),
					MessagesEnum.UNEXPECTEDFAILURE.getKey()));
		}

	}

	public String getStackTrace(AppException ke) {
		if (ke.getThrowable() != null) {
			return ExceptionUtils.getStackTrace(ke.getThrowable());
		} else {
			return ExceptionUtils.getStackTrace(ke);
		}
	}
}