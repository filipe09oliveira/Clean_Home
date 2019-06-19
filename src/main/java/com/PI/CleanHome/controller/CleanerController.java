package com.PI.CleanHome.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.PI.CleanHome.model.Cleaner;
import com.PI.CleanHome.service.CleanerService;

@Controller
public class CleanerController {

    @Autowired
    private CleanerService cleanerService;
    
	public ModelAndView findAll(HttpServletRequest r) {
		
		String email = r.getRemoteUser();
		ModelAndView mv = new ModelAndView("/index");
		
		if(email!= null) {
			Cleaner cleaner = cleanerService.findByEmail(email);
			mv.addObject("cliente", cleaner);	
		}		
		mv.addObject("cleaners", cleanerService.findAllAtivas());

		return mv;
	}
        
    
    @RequestMapping("/addCleaner")
    public String addCleaner(Cleaner cleaner, HttpServletRequest request) {
        request.setAttribute("cleaner", cleaner);
        
        return "cadastrocleaner";        
    }
    
    @RequestMapping(value = "/saveCleaner", method = RequestMethod.POST)
    public String saveCleaner(@Valid @ModelAttribute("cleaner") Cleaner cleaner, BindingResult result, HttpServletRequest request) {
        
        if(result.hasErrors()) {
            return addCleaner(cleaner, request);
        }
    
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        cleaner.setSenha(passwordEncoder.encode(cleaner.getSenha()));
        
        cleanerService.save(cleaner);
        
        EmailController.enviarEmailCliente(cleaner.getEmail(), cleaner.getNomecompleto());
        
        return "redirect:/confirmacaoPreCadastro";
    }
    
    @RequestMapping(value = "/confirmacaoPreCadastro")
    public ModelAndView confirmacaoPreCadastro (HttpServletRequest r) {
        ModelAndView mv = new ModelAndView("confirmacaoPreCadastro");
        
        return mv;
        
    }
    
    @GetMapping("/aprovarCleaner/{id}/{email}")
	public ModelAndView aprovaCleaner(@PathVariable("id") Long id, @PathVariable("email") String email) {
		try {
			
		
		ModelAndView mv = new ModelAndView("ListagemCleaner");
		
		String assuntoEmail, conteudoEmail;
		
		conteudoEmail = "Seu cadastro foi criado com sucesso! Esperamos que aproveite todos os recursos oferecidos pelo nosso sistema."
				+ "Em breve você receberá um email com instruções para finalizar o seu cadastro." ;
		assuntoEmail = "Cadastro Aprovado";
		
		Cleaner cleaner = cleanerService.findOne(id);
		cleaner.setStatus("ativo");
		cleanerService.save(cleaner);
		
		EmailController.enviarEmailCleanerConfirmacao(email, conteudoEmail,assuntoEmail);
		
		return mv;
		
		}catch(Exception e) {
			System.err.println(e);
			return null;
		}

	}
	
	@GetMapping("/recusarCleaner/{id}/{email}")
	public ModelAndView recusaCleaner(@PathVariable("id") Long id, @PathVariable("email") String email) {
		try {
		
		ModelAndView mv = new ModelAndView("ListagemCleaner");
		String assuntoEmail, conteudoEmail;
		
		assuntoEmail = "Retorno do seu cadastro";
		conteudoEmail = "Olá, como você está? Todos os pedidos que recebemos passam por uma análise interna. "
				+ "Se tivéssemos que decidir agora, não poderíamos te liberar um cadasro. Caso queira tentar"
				+ " realizar um novo cadastro e você seja aprovado entraremos em contato explicando como finalizar seu cadastro, ok?";
	
		
		
		Cleaner cleaner = cleanerService.findOne(id);
		cleaner.setStatus("recusado");
		cleanerService.save(cleaner);
		
		EmailController.enviarEmailCleanerConfirmacao(email, conteudoEmail,assuntoEmail);
		
		return mv;
		
		}catch(Exception e) {
			System.err.println(e);
			return null;
		}

	}
	
    

    @RequestMapping("/editCleaner/{id}")
    public ModelAndView editPerfilCleaner(@PathVariable ("id") Long id, HttpServletRequest r) {
        
        String email = r.getRemoteUser();
        ModelAndView mv = new ModelAndView("perfilCleaner");
        
        if(email!= null) {
            Cleaner cleaner = cleanerService.findOne(id);
            mv.addObject("cleaner", cleaner);
        }
        return mv;
    }
    
    @RequestMapping(value = "/savePerfilCleaner", method = RequestMethod.POST)
	public ModelAndView savePerfilCleaner(@Valid @ModelAttribute("cleaner") Cleaner cleaner, BindingResult result, HttpServletRequest request) {

				System.out.println(cleaner);
		
		for(ObjectError e : result.getAllErrors()) {
			System.out.println(e.getObjectName()+" - "+ e.getDefaultMessage());
			
		}
		
		if(result.hasErrors()) {
			return editPerfilCleaner(cleaner.getId(), request);
		}
		
		
		
		cleanerService.save(cleaner);
		try {
			request.login(cleaner.getEmail(), cleaner.getSenha());
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		
		return new ModelAndView("redirect:/editCleaner/"+ cleaner.getId());
	}
    
    @GetMapping("/listarCleaner")
	public ModelAndView listarCleaner(){
		
		ModelAndView mv = new ModelAndView("ListagemCleaner");
		Iterable<Cleaner> cleaners = cleanerService.findAllPendentes();
		mv.addObject("cleaners", cleaners);
		
		return mv;		
	}


}
