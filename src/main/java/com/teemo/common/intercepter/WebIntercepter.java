package com.teemo.common.intercepter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.teemo.common.exception.ResponseInfo;
import com.teemo.common.exception.ResultStatusEnum;

import lombok.extern.log4j.Log4j2;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2018年3月10日
 * @description 拦截器
 */
@Log4j2
@Component
public class WebIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		log.info("session超时时长：{}秒", request.getSession().getMaxInactiveInterval());
//		log.info("session:{}", request.getSession().getAttribute("USER"));
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
		response.setHeader("Access-Control-Allow-Credentials", "true");
//		if (request.getSession().getAttribute("USER") == null) {
//			responseOutWithJson(response);
//			return false;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
	}

	/**
	 * 返回登录失效信息
	 * @param response
	 */
	protected void responseOutWithJson(HttpServletResponse response) {
		// 将实体对象转换为JSON Object转换
		ResponseInfo<Object> result = new ResponseInfo<>();
		result.setData(null);
		result.setCode(ResultStatusEnum.login_time_out.getErrorCode());
		result.setMsg(ResultStatusEnum.login_time_out.getErrorMsg());
		result.setCurrentDate(System.currentTimeMillis());
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(gson.toJson(result));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
