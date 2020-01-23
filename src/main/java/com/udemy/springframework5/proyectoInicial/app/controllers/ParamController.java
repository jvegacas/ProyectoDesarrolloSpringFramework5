package com.udemy.springframework5.proyectoInicial.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ParamController {
	
	@GetMapping(value = "/params")
	public String pasarString(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "edad",required = false) Integer edad, Model model) {
		model.addAttribute("pasarNombre", "Usuario: "+nombre+" "+edad.toString());
		return "/params/pasar";
	}
	
//	@ModelAttribute("apellido")
//	public String pasarApellido(@RequestParam(value = "apellido",required = false) String apellido) {
//		return apellido;
//
//	}
	
	@GetMapping("/paramHttpServlet")
	public String pasarHttp(HttpServletRequest request, Model model) {
		String frase = (String) request.getParameter("frase");
		Integer numero =  Integer.parseInt(request.getParameter("numero"));
		model.addAttribute("frase", "La frase es: "+frase+ " y el número es: "+numero);
		return "index";
	}

}
