package org.farmacia.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.farmacia.bean.Respuesta;
import org.farmacia.bean.Usuario;
import org.farmacia.service.UsuarioService;
import org.farmacia.util.JsonUtil;
import org.farmacia.util.UConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/iniciarSesion")
	public @ResponseBody String iniciarSesion(HttpServletRequest request) throws ParseException {

		Usuario usuario = new Usuario();
		Respuesta respuesta= new Respuesta();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		usuario.setCodUsuario(username);
		usuario.setPassword(password);
		int res= usuarioService.verificarLogin(usuario);
		if (res>0) {
			respuesta.setEstadoRespuesta(UConstantes.OK);	
		}
		else
		{
			respuesta.setEstadoRespuesta(UConstantes.ERROR);	
		}
		
		return JsonUtil.convertirObjetoACadenaJson(respuesta);
	}
	


}
