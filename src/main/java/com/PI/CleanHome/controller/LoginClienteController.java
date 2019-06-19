/*package com.PI.CleanHome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.PI.CleanHome.model.Cliente;
import com.PI.CleanHome.service.ClienteService;

@Controller
public class LoginClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/loginCliente", method=RequestMethod.GET)
	public String getLoginCliente() {
		return "loginCliente";
	}
	
	@RequestMapping(value="/loginCliente", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="cliente") Cliente cliente, Model model) {
		
		ModelAndView mv = new ModelAndView("/loginCliente");
		
		String email = cliente.getEmail();
		String senha = cliente.getSenha();
		
		Cliente autenticar = service.autenticarLogin(email, senha);
			
		if(autenticar != null) {
			return "index";
		}else {
			mv.addObject("erro", true);
			return "loginCliente";
		}
				
		
	}
}*/
