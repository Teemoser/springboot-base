package com.teemo.common.exception;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2018年2月2日
 * @description 此处继承RuntimeException防止service内未指定回滚异常@Transaction事务注解失效
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -9062384660967933508L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	private String messageCode;

	private Object[] messageParameters;

	public ServiceException() {

		super();
	}

	public ServiceException(Throwable cause) {

		super(cause);
	}

	public String getMessageCode() {

		return messageCode;
	}

	public void setMessageCode(String messageCode) {

		this.messageCode = messageCode;
	}

	public Object[] getMessageParameters() {

		return messageParameters;

	}

	public void setMessageParameters(Object[] messageParameters) {

		this.messageParameters = messageParameters;
	}
}
