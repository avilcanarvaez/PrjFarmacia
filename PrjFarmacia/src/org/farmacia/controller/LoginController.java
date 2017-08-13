package org.farmacia.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	
	@GetMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/iniciarSesion")
	public String iniciarSesion(HttpServletRequest request) throws ParseException {

		//Cliente usuario = new Cliente();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("username -->"+username);
		System.out.println("password -->"+password);
//		usuario.setNombre(nombre);
//		usuario.setApePaterno(apePaterno);

		//this.clienteService.insertar(usuario);
		//return "redirect:/index";
		return "redirect:/index";  
	}
	


}
