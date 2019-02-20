package com.myspringlearnings.spring.web.data_model;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {

	/*
	 * @RequestMapping("/") public ModelAndView showPage() {
	 * 
	 * ModelAndView mv = new ModelAndView("home"); Map<String, Object> model =
	 * mv.getModel(); model.put("name", "<b>Dharu</b>");
	 * 
	 * return mv; }
	 */

	@RequestMapping("/")
	public String showPage(Model model) {
		model.addAttribute("name", "<b>Dharani</b>");
		return "home";
	}
}
