package com.duoqio.cloud.datasource.druid.stat;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.support.http.WebStatFilter;
import com.duoqio.cloud.datasource.druid.properties.DruidStatProperties;

@ConditionalOnWebApplication
@ConditionalOnProperty(name = "spring.datasource.druid.web-stat-filter.enabled", havingValue = "true", matchIfMissing = true)
public class DruidWebStatFilterConfiguration {

	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilterRegistrationBean(DruidStatProperties properties) {
		DruidStatProperties.WebStatFilter config = properties.getWebStatFilter();
		FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>();
		WebStatFilter filter = new WebStatFilter();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns(config.getUrlPattern() != null ? config.getUrlPattern() : "/*");
		registrationBean.addInitParameter("exclusions", config.getExclusions() != null ? config.getExclusions()
				: "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		if (config.getSessionStatEnable() != null) {
			registrationBean.addInitParameter("sessionStatEnable", config.getSessionStatEnable());
		}
		if (config.getSessionStatMaxCount() != null) {
			registrationBean.addInitParameter("sessionStatMaxCount", config.getSessionStatMaxCount());
		}
		if (config.getPrincipalSessionName() != null) {
			registrationBean.addInitParameter("principalSessionName", config.getPrincipalSessionName());
		}
		if (config.getPrincipalCookieName() != null) {
			registrationBean.addInitParameter("principalCookieName", config.getPrincipalCookieName());
		}
		if (config.getProfileEnable() != null) {
			registrationBean.addInitParameter("profileEnable", config.getProfileEnable());
		}
		return registrationBean;
	}

}
