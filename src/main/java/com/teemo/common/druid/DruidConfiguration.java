package com.teemo.common.druid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * @author xiaojin_wu
 * @email wuxiaojin258@126.com
 * @date 2019年3月16日
 * @description druid控制台配置账号密码
 */
@Configuration
public class DruidConfiguration {

	@Value("${spring.druid.statview.username}")
	private String username;

	@Value("${spring.druid.statview.password}")
	private String password;

	@Bean
	public ServletRegistrationBean<StatViewServlet> DruidStatViewServlet() {
		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
		ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),
				"/druid/*");
		// 添加初始化参数
		servletRegistrationBean.addInitParameter("loginUsername", username);
		servletRegistrationBean.addInitParameter("loginPassword", password);
		// 是否可以重置
		servletRegistrationBean.addInitParameter("resetEnable", "fase");
		return servletRegistrationBean;
	}

}