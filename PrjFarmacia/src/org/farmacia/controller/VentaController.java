package org.farmacia.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.farmacia.bean.DetalleOrdenPedido;
import org.farmacia.bean.OrdenPedido;
import org.farmacia.service.ClienteService;
import org.farmacia.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VentaController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/cargarVentanaVentas")
	public String cargarVentanaVentas(Model model) {
		return "ventas/registrarVenta";
	}
	
	@PostMapping(value="/accionObtenerClienteXDni")
    public @ResponseBody String accionObtenerClienteXDni(HttpServletRequest request){   
		System.out.println("Inicio accionObtenerClienteXDni()");
    	long dni= Long.parseLong(request.getParameter("numDocumento"));
        String CadenaJson=null;
        try {
        	  CadenaJson=JsonUtil.convertirObjetoACadenaJson(clienteService.obtener(dni));
		} catch (Exception exception) {
			//throw new Exception(exception);
		}
       
        return CadenaJson;
    }
	
	
	
	@PostMapping(value = "/finalizarVenta")
	public @ResponseBody String finalizarVenta(HttpServletRequest request) throws ParseException {
		System.out.println("finalizarVenta()--");
		long idCliente= Long.parseLong(request.getParameter("idCliente"));
		long idUsuario=1;
		String infoProducto =request.getParameter("productos");
		String aInfoProducto[]= infoProducto.split("/");
		String aInfoProductoTmp[];
		
		
		OrdenPedido ordenPedido= new OrdenPedido();
		List<DetalleOrdenPedido> listaDetalleOrdenPedido=new ArrayList<DetalleOrdenPedido>(); 
		DetalleOrdenPedido detalleOrdenPedido;
		
		ordenPedido.setIdCliente(idCliente);
		ordenPedido.setIdUsuario(idUsuario);
		ordenPedido.setTotal(0.0);
		
		String idProducto;
		String nombreProducto;
		String cantidad;
		String precioVenta;
		
		for (int i = 0; i < aInfoProducto.length; i++) {
			aInfoProductoTmp=aInfoProducto[i].split("-");
			nombreProducto=aInfoProductoTmp[0].toString();
			precioVenta=aInfoProductoTmp[1].toString();
			cantidad=aInfoProductoTmp[2].toString();
			
			
			detalleOrdenPedido= new DetalleOrdenPedido();
			//detalleOrdenPedido.setIdProducto(idProducto);
			detalleOrdenPedido.setNombreProducto(nombreProducto);
			detalleOrdenPedido.setCantidad(Long.parseLong(cantidad) );
			detalleOrdenPedido.setPrecioVenta(Double.parseDouble(precioVenta) );
			listaDetalleOrdenPedido.add(detalleOrdenPedido);
		}	
		
		ordenPedido.setListaDetalleOrdenPedido(listaDetalleOrdenPedido);
		
		
//		Cliente usuario = new Cliente();
//		String nombre = request.getParameter("nombre");
//		String apePaterno = request.getParameter("apePaterno");
//		String apeMaterno = request.getParameter("apeMaterno");
//		String nroDocumento= request.getParameter("nroDocumento");
//		String fechaNacimiento = request.getParameter("nacimiento");
//		String correo =  request.getParameter("correo");
//		String direccion = request.getParameter("direccion");
//		String telefono = request.getParameter("telefono");
//
//		usuario.setNombre(nombre);
//		usuario.setApePaterno(apePaterno);
//		usuario.setApeMaterno(apeMaterno);
//		usuario.setNroDocumento(nroDocumento);
//		usuario.setFechaNacimiento(this.parseDate(fechaNacimiento));
//		usuario.setCorreo(correo);
//		usuario.setDireccion(direccion);
//		usuario.setTelefono(telefono);
//		this.clienteService.insertar(usuario);
		//return "redirect:/index";
	    return JsonUtil.convertirObjetoACadenaJson(1);  
	}

}
