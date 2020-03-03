package fr.cbox.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	public static final String HELLO_WORLD_VIEW = "helloWorld";
	
	@GetMapping("/hello")
	public ModelAndView helloWorld() {		
		ModelAndView mv = new ModelAndView(HELLO_WORLD_VIEW);
		mv.addObject("title", "Hello World !");
		return mv;
	}

}
