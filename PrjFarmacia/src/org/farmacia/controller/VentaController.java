package org.farmacia.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.farmacia.bean.Cliente;
import org.farmacia.bean.DetalleOrdenPedido;
import org.farmacia.bean.OrdenPedido;
import org.farmacia.bean.Producto;
import org.farmacia.bean.Respuesta;
import org.farmacia.service.ClienteService;
import org.farmacia.service.OrdenPedidoService;
import org.farmacia.service.ProductoService;
import org.farmacia.util.JsonUtil;
import org.farmacia.util.UConstantes;
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
	
	@Autowired
	OrdenPedidoService ordenPedidoService;
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping(value = "/cargarVentanaVentas")
	public String cargarVentanaVentas(Model model) {
		return "ventas/registrarVenta";
	}
	
	@PostMapping(value="/accionObtenerClienteXDni")
    public @ResponseBody String accionObtenerClienteXDni(HttpServletRequest request){   
		System.out.println("Inicio accionObtenerClienteXDni()");
		Respuesta respuesta = new Respuesta();
		Cliente cliente= new Cliente();
		Map<String, Object> parametros = new HashMap<String, Object>();
		
    	long dni= Long.parseLong(request.getParameter("numDocumento"));
        //String CadenaJson=null;
        try {
        		 cliente=clienteService.obtener(dni);
        		 respuesta.setEstadoRespuesta(UConstantes.OK);
        		 parametros.put("cliente", cliente);
        		 respuesta.setParametros(parametros);
        		 //CadenaJson=JsonUtil.convertirObjetoACadenaJson(clienteService.obtener(dni));
		} catch (Exception exception) {
			respuesta.setEstadoRespuesta(UConstantes.ERROR);
			respuesta.setMensajeRespuesta(exception.toString());
		}
        System.out.println("Fin accionObtenerClienteXDni()");
        return JsonUtil.convertirObjetoACadenaJson(respuesta);
    }
	
	@PostMapping(value="/accionObtenerProductoXCodigo")
    public @ResponseBody String accionObtenerProductoXCodigo(HttpServletRequest request){   
		System.out.println("Inicio accionObtenerProductoXCodigo()");
		Respuesta respuesta = new Respuesta();
		Producto producto= new Producto();
		Map<String, Object> parametros = new HashMap<String, Object>();
    	String codProducto= request.getParameter("codProducto");
        try {
        	producto=productoService.obtenerProductoXCodigo(codProducto);
        		 respuesta.setEstadoRespuesta(UConstantes.OK);
        		 parametros.put("producto", producto);
        		 respuesta.setParametros(parametros);
		} catch (Exception exception) {
			respuesta.setEstadoRespuesta(UConstantes.ERROR);
			respuesta.setMensajeRespuesta(exception.toString());
		}
        System.out.println("Fin accionObtenerProductoXCodigo()");
        return JsonUtil.convertirObjetoACadenaJson(respuesta);
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
			idProducto=aInfoProductoTmp[0].toString();
			nombreProducto=aInfoProductoTmp[1].toString();
			cantidad=aInfoProductoTmp[2].toString();
			precioVenta=aInfoProductoTmp[3].toString();			
			detalleOrdenPedido= new DetalleOrdenPedido();
			detalleOrdenPedido.setIdProducto(Long.parseLong(idProducto));
			detalleOrdenPedido.setNombreProducto(nombreProducto);
			detalleOrdenPedido.setCantidad(Long.parseLong(cantidad) );
			detalleOrdenPedido.setPrecioVenta(Double.parseDouble(precioVenta) );
			listaDetalleOrdenPedido.add(detalleOrdenPedido);
		}	
		
		ordenPedido.setListaDetalleOrdenPedido(listaDetalleOrdenPedido);
		this.ordenPedidoService.insertar(ordenPedido);
	    return JsonUtil.convertirObjetoACadenaJson(1);  
	}

}
