package com.PI.CleanHome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.PI.CleanHome.model.Service;
import com.PI.CleanHome.model.Socket;
import com.PI.CleanHome.service.SocketService;

@RestController

@RequestMapping("/servicos")
public class ServiceController {
	
	@Autowired
	private SocketService socketService;
	
	@PostMapping("/criar/{id}")
	public Service criar(@PathVariable int id) {
		Socket socket = socketService.localizar(id, "CLEANER");
		Service service = null;
		if (socket != null) {
			service = new Service(12l, 95.0f, "aberto", socket.getSocketId());
		}
		
		return service;
	}
	
	
	@GetMapping("/buscar/{id}")
	public Service buscar(@PathVariable int id) {
		Service service = new Service(12l, 95.0f, "aberto", "");
		
		return service;
	}
	
	@GetMapping("/solicitaServico/")
	public ModelAndView solicitarServico() {
		
		ModelAndView mv = new ModelAndView("pagamentoServico");
		
		return mv;
		
	}
}
