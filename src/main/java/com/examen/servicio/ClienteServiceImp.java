package com.examen.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Cliente;
import com.examen.repositorio.ClienteRepositorio;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepositorio repositorio;
	
	@Override
	public Cliente registraCliente(Cliente obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

}
