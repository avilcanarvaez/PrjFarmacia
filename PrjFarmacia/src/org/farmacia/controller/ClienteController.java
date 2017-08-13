package org.farmacia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.farmacia.bean.Cliente;
import org.farmacia.service.ClienteService;
import org.farmacia.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@GetMapping(value = { "/", "/index" })
	public String index() {
		System.out.println("Mostrando Inicio");
		return "index";
	}
//	
//	@GetMapping(value = "/listarUsuarios")
//	public ModelAndView listarUsuarios() {
//		List<Cliente> usuarios = this.clienteService.listar();
//		return new ModelAndView("listaUsuarios", "listaUsuarios", usuarios);
//	}

	@PostMapping(value = "/crearCliente")
	public @ResponseBody String crearCliente(HttpServletRequest request) throws ParseException {
		System.out.println("crearCliente()--");
		Cliente usuario = new Cliente();
		String nombre = request.getParameter("nombre");
		String apePaterno = request.getParameter("apePaterno");
		String apeMaterno = request.getParameter("apeMaterno");
		String nroDocumento= request.getParameter("nroDocumento");
		String fechaNacimiento = request.getParameter("nacimiento");
		String correo =  request.getParameter("correo");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");

		usuario.setNombre(nombre);
		usuario.setApePaterno(apePaterno);
		usuario.setApeMaterno(apeMaterno);
		usuario.setNroDocumento(nroDocumento);
		usuario.setFechaNacimiento(this.parseDate(fechaNacimiento));
		usuario.setCorreo(correo);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		this.clienteService.insertar(usuario);
		//return "redirect:/index";
	    return JsonUtil.convertirObjetoACadenaJson(1);  
	}

	@GetMapping(value = "/registrarCliente")
	public String registrarCliente() {
		return "cliente/registrarCliente";
	}
	
	private Date parseDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(date);
	}
	
	@GetMapping(value = "/administrarCliente")
	public String administrarCliente(Model model) {
		model.addAttribute("listaClientes", JsonUtil.convertirObjetoACadenaJson(clienteService.listar()));
		return "cliente/administrarCliente";
	}
	
    //@RequestMapping(value="/accionBuscarCliente", method=RequestMethod.POST)
	@PostMapping(value="/accionBuscarCliente")
    public @ResponseBody String accionBuscarCliente(HttpServletRequest request){   
		System.out.println("Inicio accionBuscarCliente()");
    	Map<String, Object> parametrosBusqueda = JsonUtil.convertirCadenaJsonAObjeto(request.getParameter("parametrosBusqueda"), HashMap.class);
        String CadenaJson=null;
        try {
        	  CadenaJson=JsonUtil.convertirObjetoACadenaJson(clienteService.listarClientesPorParametroBusqueda(parametrosBusqueda));
		} catch (Exception exception) {
			//throw new Exception(exception);
		}
       
        return CadenaJson;
    }
	
}