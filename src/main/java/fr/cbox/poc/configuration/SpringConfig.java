package fr.cbox.poc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Remplace le fichier de configuration des beans
 * @author XYSW970
 *
 */
@EnableWebMvc // active les annotations Spring MVC commen @Controller
@Configuration // indique que cette classe est une fichier de configuration pour obtenir des beans
@ComponentScan(basePackages = "fr.cbox.poc") // indique quels sont les packages à scanner pour récupérer les Controller, Service, Repositories, Beans
public class SpringConfig implements WebMvcConfigurer {

	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/view/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
}
