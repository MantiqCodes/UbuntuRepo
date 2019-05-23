		
package com.retail.store.discount;
		
		import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
		
		@Component
		public class WebMvcConfig implements WebMvcConfigurer {
		
			@Override
			public void configureViewResolvers(ViewResolverRegistry registry) {
				InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
				internalResourceViewResolver.setPrefix("WEB-INF/pages/");
				internalResourceViewResolver.setSuffix(".jsp");
				internalResourceViewResolver.setViewClass(JstlView.class);
				registry.viewResolver(internalResourceViewResolver);
			}
		}
