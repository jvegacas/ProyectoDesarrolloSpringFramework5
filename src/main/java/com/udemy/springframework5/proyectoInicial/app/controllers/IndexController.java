package com.udemy.springframework5.proyectoInicial.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping(value = {"/index",""})
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/indexModel")
	public String indexModel (Model model) {
		model.addAttribute("titulo", "Spring FrameWork con Model");
		return "index";
	}
	
	@GetMapping(value = "/indexModelAndView")
	public ModelAndView indexModelAnView (ModelAndView mv) {
		mv.addObject("titulo", "Spring FrameWork con ModelAndView");
		mv.setViewName("index");
		return mv;
	} 
	
	@GetMapping(value = "/indexMap")
	public String indexMap (Map<String, Object> mp) {
		mp.put("titulo", "SpringFrameWork con Map");
		return "index";
	}

}
