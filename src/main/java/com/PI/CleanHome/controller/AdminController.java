package com.PI.CleanHome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.PI.CleanHome.model.Admin;
import com.PI.CleanHome.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	public ModelAndView findAll(HttpServletRequest r) {
		
		String email = r.getRemoteUser();
		ModelAndView mv = new ModelAndView("/index");
		
		if(email!= null) {
			Admin admin = service.findByEmail(email);
			System.out.println("Admin: " +admin);
			mv.addObject("admin", admin);
		}		
		
		mv.addObject("admins", service.findAll());
		return mv;
	}
	
	@RequestMapping("/AddAdmin")
	public String addAdmin(Admin admin, HttpServletRequest request) {
		request.setAttribute("admin", admin);
		
		return "cadastroadmin";		
	}
	
	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return addAdmin(admin, request);
		}
	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		admin.setSenha(passwordEncoder.encode(admin.getSenha()));
		
		service.save(admin);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/tabelaDashbordCleaner")
	public ModelAndView tabelaDashbordCleaner (HttpServletRequest r) {
		ModelAndView mv = new ModelAndView("tabelaDashbordCleaner");
		
		return mv;
		
	}
	
	//MAPEAÇÃO DO PERFIL DO CLIENTE
	@RequestMapping("/editAdmin/{id}")
	public ModelAndView editPerfil(@PathVariable ("id") Long id, ModelMap model, HttpServletRequest r) {
		
		String email = r.getRemoteUser();
		ModelAndView mv = new ModelAndView("cadastroadmin");
		
		if(email!= null) {
			Admin admin = service.get(id);
			mv.addObject("admin", admin);
		}
		return mv;		
	}
}
