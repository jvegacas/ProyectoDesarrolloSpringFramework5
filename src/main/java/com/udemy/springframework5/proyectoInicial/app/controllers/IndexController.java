package com.udemy.springframework5.proyectoInicial.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.springframework5.proyectoInicial.app.models.Usuario;

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
	
	@GetMapping(value = "/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Javi");
		usuario.setApellido("Vega");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Usuario: ".concat(usuario.getNombre()).concat(" ").concat(usuario.getApellido()));
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("aa","bb"));
		usuarios.add(new Usuario("cc","dd"));
		usuarios.add(new Usuario("ee","ff"));
		
		model.addAttribute("usuarios",usuarios);
		return "perfil";
		
	}
	
	@GetMapping(value = "/perfiles")
	public String listarPerfiles(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("aa","bb"));
		usuarios.add(new Usuario("cc","dd"));
		usuarios.add(new Usuario("ee","ff"));
		
		model.addAttribute("usuarios",usuarios);
		
		return "perfil";
	}
	
	@ModelAttribute("usuariosglobales")
	public List<Usuario> listarUsuariosGlobales(){
		List<Usuario> usuGlobales = new ArrayList<>();
		usuGlobales = Arrays.asList(new Usuario("aaGlobal", "bbGlobal"), new Usuario("ccGlobal", "ddGlobal"));
		return usuGlobales;
	}

}
