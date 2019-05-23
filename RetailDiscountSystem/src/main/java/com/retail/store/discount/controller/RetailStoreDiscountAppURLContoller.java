package com.retail.store.discount.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RetailStoreDiscountAppURLContoller

{

	@Autowired
	private Environment env;

	@RequestMapping(value = { "/", "/index**" }, method = RequestMethod.GET)

	public String showHomePage(ModelMap model, ServletRequest servletRequest)
	{

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String url = httpServletRequest.getRequestURL().toString();
		String ip = httpServletRequest.getRequestURI();
		if (url.contains("//") && url.contains(":"))
		{
			int start = url.indexOf("//");
			int end = url.lastIndexOf(":");
			if (start < end)
			{
				ip = url.substring(start + 2, end);
			}
		}
		model.addAttribute("ip", ip);
		model.addAttribute("port", env.getProperty("server.port"));
		return "URLList";

	}

}
