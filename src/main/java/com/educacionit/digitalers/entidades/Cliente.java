package com.educacionit.digitalers.entidades;

public class Cliente {
	private Integer id_cliente;
	private String calle;
	private String ciudad;
	private Integer id_empleado;
	
	
	
	public Cliente() {
		super();
	}
	public Cliente(Integer id_cliente, String calle, String ciudad, Integer id_empleado) {
		super();
		this.id_cliente = id_cliente;
		this.calle = calle;
		this.ciudad = ciudad;
		this.id_empleado = id_empleado;
	}
	

	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", calle=" + calle + ", ciudad=" + ciudad
				+ ", id_empleado=" + id_empleado + "]";
	}
	
	
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	
}


