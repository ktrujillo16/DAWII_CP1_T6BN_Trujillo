package com.examen.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.examen.entidad.Cliente;
import com.examen.entidad.Tipo;
import com.examen.servicio.ClienteService;
import com.examen.servicio.TipoService;

@Controller
@SessionAttributes("MENSAJE")
public class ClienteController {
	
	@Autowired
	private TipoService serviceTipo;

	@Autowired
	private ClienteService serviceCliente;
	
	@RequestMapping("/verCliente")
	public String verCliente() {
		return "registraCliente";
	}

	@RequestMapping("/cargaTipo")
	@ResponseBody
	public List<Tipo> cargaTipo(){
		return serviceTipo.listaTipo();
	}
	
	@RequestMapping("/registraCliente")
	public String registraCliente(Cliente obj, Model m) {
		Cliente aux = serviceCliente.registraCliente(obj);
		
		if(aux == null) { 
			m.addAttribute("MENSAJE", "Hubo un error en el registro");
		}else { 
			m.addAttribute("MENSAJE", aux.getNom_cliente()+" se registro correctamente");
		}
		return "redirect:verCliente";
	}
	
}

