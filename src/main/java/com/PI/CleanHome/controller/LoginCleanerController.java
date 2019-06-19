/*	package com.PI.CleanHome.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import com.PI.CleanHome.model.Cleaner;
import com.PI.CleanHome.model.Cliente;
import com.PI.CleanHome.service.CleanerService;
import com.PI.CleanHome.service.ClienteService;

public class LoginCleanerController {
	



		@Autowired
		private CleanerService service;
		
		@RequestMapping(value="/loginCleaner", method=RequestMethod.GET)
		public String getLoginCliente() {
			return "loginCleaner";
		}
		
		@RequestMapping(value="/loginCleaner", method=RequestMethod.POST)
		public String login(@ModelAttribute(name="cleaner") Cleaner cleaner, Model model) {
			
			ModelAndView mv = new ModelAndView("/loginCleaner");
			
			String email = cleaner.getEmail();
			//String senha = cleaner.getSenha();
			
			Cleaner autenticar = service.autenticarLogin(email);
			//Cleaner autenticar = service.autenticarLogin(email, senha);
				
			if(autenticar != null) {
				return "Perfil";
			}else {
				mv.addObject("erro", true);
				return "loginCleaner";
			}
					
			
		}
	

}*/
