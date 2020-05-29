package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
