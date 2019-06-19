package com.PI.CleanHome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.PI.CleanHome.model.Admin;
import com.PI.CleanHome.model.Cleaner;
import com.PI.CleanHome.model.Cliente;
import com.PI.CleanHome.service.AdminService;
import com.PI.CleanHome.service.CleanerService;
import com.PI.CleanHome.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private	CleanerService cleanerService;
	@Autowired
	private	AdminService adminService;
	
	
	@RequestMapping("/")
	public ModelAndView findAll(HttpServletRequest r) {
		
		String email = r.getRemoteUser();
		ModelAndView mv = new ModelAndView("/index");
		
		if(email!= null) {
			Cliente cliente = clienteService.findByEmail(email);
			Cleaner cleaner = cleanerService.findByEmail(email);
			Admin admin = adminService.findByEmail(email);
			
			if(cliente != null) {
				mv.addObject("cliente", cliente);	
			} else if(cleaner != null) {
				mv.addObject("cleaner", cleaner);	
			} else {
				mv.addObject("admin", admin);	
			}
		}		
		mv.addObject("clientes", clienteService.findAll());
		mv.addObject("cleaners", cleanerService.findAllAtivas());

		return mv;
	}
	
	@RequestMapping("/Add")
	public String addCliente(Cliente cliente, HttpServletRequest request) {
		request.setAttribute("cliente", cliente);
		
		return "cadastrocliente";		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println(result);
			return addCliente(cliente, request);
		}
	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
		
		clienteService.save(cliente);
		
		EmailController.enviarEmailCliente(cliente.getEmail(), cliente.getNome());
		
		return "redirect:/confirmacaoCadastroCliente";
	}
	
	@RequestMapping(value = "/confirmacaoCadastroCliente")
	public ModelAndView confirmacaoCadastroCliente (HttpServletRequest r) {
		ModelAndView mv = new ModelAndView("confirmacaoCadastroCliente");
		
		return mv;
		
	}
	
	//MAPEAÇÃO DO PERFIL DO CLIENTE
	@RequestMapping("/edit/{id}")
	public ModelAndView editPerfil(@PathVariable ("id") Long id, HttpServletRequest r) {
		
		String email = r.getRemoteUser();
		ModelAndView mv = new ModelAndView("perfilCliente");
		
		if(email!= null) {
			Cliente cliente = clienteService.findOne(id);
			mv.addObject("cliente", cliente);
		}
		return mv;		
	}
	
	@RequestMapping(value = "/savePerfilCliente", method = RequestMethod.POST)
	public ModelAndView savePerfilCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, HttpServletRequest request) {

				System.out.println(cliente);
		
		for(ObjectError e : result.getAllErrors()) {
			System.out.println(e.getObjectName()+" - "+e.getDefaultMessage());
		}
		
		if(result.hasErrors()) {
			return editPerfil(cliente.getId(), request);
		}
		
		
		
		clienteService.save(cliente);
		try {
			request.login(cliente.getEmail(), cliente.getSenha());
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		
		return new ModelAndView("redirect:/edit/"+cliente.getId());
	}
	
	
	
	
	@GetMapping("/login")
	public ModelAndView login(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
}	
