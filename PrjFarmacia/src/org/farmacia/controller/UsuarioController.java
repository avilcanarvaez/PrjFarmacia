package org.farmacia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.farmacia.bean.Usuario;
import org.farmacia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping(value = { "/", "/index" })
	public String index() {
		System.out.println("Mostrando Inicio");
		return "index";
	}
	
	@GetMapping(value = "/listarUsuarios")
	public ModelAndView listarUsuarios() {
		List<Usuario> usuarios = this.usuarioService.listar();
		return new ModelAndView("listaUsuarios", "listaUsuarios", usuarios);
	}

	@PostMapping(value = "/crearUsuario")
	public String crearUsuario(HttpServletRequest request) throws ParseException {
		Usuario usuario = new Usuario();

		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		String apePaterno = request.getParameter("apePaterno");
		String apeMaterno = request.getParameter("apeMaterno");
		String fechaNacimiento = request.getParameter("nacimiento");

		usuario.setNombre(nombre);
		usuario.setClave(clave);
		usuario.setApePaterno(apePaterno);
		usuario.setApeMaterno(apeMaterno);
		usuario.setFechaNacimiento(this.parseDate(fechaNacimiento));
		this.usuarioService.insertar(usuario);
		return "redirect:/index";
	}

	@GetMapping(value = "/ingresarUsuario")
	public String ingresarUsuario() {
		return "ingresaUsuario";
	}
	
	private Date parseDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(date);
	}
	
}
