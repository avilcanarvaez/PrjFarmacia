package org.farmacia.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.farmacia.service.ClienteService;
import org.farmacia.service.ProductoService;
import org.farmacia.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;

	@GetMapping(value = "/bandejaProducto" )
	public String bandejaProducto(Model model) {
		System.out.println("Mostrando bandejaProducto");
		model.addAttribute("listaProducto", JsonUtil.convertirObjetoACadenaJson(productoService.listar()));
		return "producto/bandejaProducto";
	}
	
	
//	@PostMapping(value="/accionBuscarProducto")
//    public @ResponseBody String accionBuscarProducto(HttpServletRequest request){   
//		System.out.println("Inicio accionBuscarProducto()");
//    	Map<String, Object> parametrosBusqueda = JsonUtil.convertirCadenaJsonAObjeto(request.getParameter("parametrosBusqueda"), HashMap.class);
//        String CadenaJson=null;
//        try {
//        	  CadenaJson=JsonUtil.convertirObjetoACadenaJson(productoService.listarProductoPorParametroBusqueda(parametrosBusqueda));
//		} catch (Exception exception) {
//			//throw new Exception(exception);
//		}
//       
//        return CadenaJson;
//    }

}
