package com.myspringlearnings.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {

	// Type 1 : to render model 
	/*@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();

		model.put("name", "dharu");
		return mv;
	}*/
	
	//Type 2 : model rendering 
	@RequestMapping("/")
	public String showHome(Model model) { 
		model.addAttribute("name","Karthik");
		return "home"; 
	}

}
