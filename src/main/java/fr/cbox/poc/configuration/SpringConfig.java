package fr.cbox.poc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Remplace le fichier de configuration des beans
 *
 */
@EnableWebMvc // active les annotations Spring MVC commen @Controller
@Configuration // indique que cette classe est une fichier de configuration pour obtenir des beans
@ComponentScan(basePackages = "fr.cbox.poc") // indique quels sont les packages à scanner pour récupérer les Controller, Service, Repositories, Beans
public class SpringConfig implements WebMvcConfigurer {

	public static final String JSP_PREFIX = "/WEB-INF/view/";
	public static final String JSP_SUFFIX = ".jsp";
	public static final int JSP_VIEW_ORDER = 1;
	public static final int TILES_VIEW_ORDER = 0;
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver  bean = new UrlBasedViewResolver ();
	    bean.setViewClass(JstlView.class);
	    bean.clearCache();
	    bean.setPrefix(JSP_PREFIX);
	    bean.setSuffix(JSP_SUFFIX);
	    bean.setOrder(JSP_VIEW_ORDER);
	    return bean;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
	    TilesViewResolver bean = new TilesViewResolver();
	    bean.clearCache();
	    bean.setOrder(TILES_VIEW_ORDER);
	    return bean;
	}
	
	@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        // tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/templating/tiles.xml",
        //        "/WEB-INF/templating/**/tiles.xml" });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
}
