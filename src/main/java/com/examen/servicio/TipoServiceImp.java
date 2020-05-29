package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Tipo;
import com.examen.repositorio.TipoRepositorio;

@Service
public class TipoServiceImp implements TipoService {

	@Autowired
	private TipoRepositorio repositorio;
	
	@Override
	public List<Tipo> listaTipo() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
