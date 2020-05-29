package com.examen.entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_cliente")
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_cliente")
	private int cod_cliente;
	@Column(name="nom_cliente")
	private String nom_cliente;
	@Column(name="ape_cliente")
	private String ape_cliente;
	@Column(name="dni_cliente")
	private String dni_cliente;
	@Column(name="fec_nac_cliente")
	private String fec_nac_cliente;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private Tipo tipo;

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getApe_cliente() {
		return ape_cliente;
	}

	public void setApe_cliente(String ape_cliente) {
		this.ape_cliente = ape_cliente;
	}

	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	

	public String getFec_nac_cliente() {
		return fec_nac_cliente;
	}

	public void setFec_nac_cliente(String fec_nac_cliente) {
		this.fec_nac_cliente = fec_nac_cliente;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}
