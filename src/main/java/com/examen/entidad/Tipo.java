package com.examen.entidad;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_tipo")
	private int cod_tipo;
	@Column(name="nom_tipo")
	private String nom_tipo;
	
	@OneToMany(mappedBy = "tipo")
	private List<Cliente>clientes;
	
	
	
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getNom_tipo() {
		return nom_tipo;
	}
	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}
	
	
}
