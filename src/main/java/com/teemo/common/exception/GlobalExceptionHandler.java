package com.teemo.common.exception;

import java.net.BindException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice(annotations = { RestController.class })
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseInfo<?> defaultErrorHandler(HttpServletRequest request, Exception e) {

		log(request, e);

		ResponseInfo<?> errorInfo = chenckException(e);

		errorInfo.setData(null);
		errorInfo.setCurrentDate(System.currentTimeMillis());
		return errorInfo;
	}

	/**
	 * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		ResponseInfo<?> result = new ResponseInfo<>();
		result.setCode(ResultStatusEnum.http_status_bad_request.getErrorCode());
		result.setMsg("缺少请求参数");
		result.setCurrentDate(System.currentTimeMillis());
		return new ResponseEntity<>(result, HttpStatus.NOT_EXTENDED);
	}

	/**
	 * 
	 * 日志记录
	 * 
	 * @param e
	 * @param request
	 */
	private void log(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		String name = null;
		log.error("*********************************** Exception Start *************************************");
		log.error(e);
		Enumeration<?> enumeration = request.getParameterNames();
		if (enumeration.hasMoreElements()) {
			log.error("request parameters is:");
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement().toString();
				log.error(name + "-->" + request.getParameter(name));
			}
		}

		StackTraceElement[] error = e.getStackTrace();
		for (StackTraceElement stackTraceElement : error) {
			log.error(stackTraceElement.toString());
		}
		log.error("***********************************  Exception End  *************************************");
	}

	public ResponseInfo<?> chenckException(Exception e) {
		ResponseInfo<?> errorInfo = new ResponseInfo<>();
		if (e instanceof MissingServletRequestParameterException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("缺少请求参数");
		} else if (e instanceof HttpMessageNotReadableException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("参数解析失败");
		} else if (e instanceof MethodArgumentNotValidException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("参数验证失败");
		} else if (e instanceof ConstraintViolationException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("参数验证失败");
		} else if (e instanceof BindException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("参数绑定失败");
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			errorInfo.setCode(405);
			errorInfo.setMsg("不支持当前请求方法");
		} else if (e instanceof HttpMediaTypeNotSupportedException) {
			errorInfo.setCode(415);
			errorInfo.setMsg("不支持当前媒体类型");
		} else if (e instanceof ServiceException) {
			errorInfo.setCode(400);
			errorInfo.setMsg(e.getMessage());
		} else if (e instanceof ParseException) {
			errorInfo.setCode(400);
			errorInfo.setMsg("日期格式错误");
		} else if (e instanceof LoginException) {
			errorInfo.setCode(1000);
			errorInfo.setMsg(e.getMessage());
		} else {
			errorInfo.setCode(500);
			errorInfo.setMsg("服务器开小差啦~");
		}
		return errorInfo;
	}

}
