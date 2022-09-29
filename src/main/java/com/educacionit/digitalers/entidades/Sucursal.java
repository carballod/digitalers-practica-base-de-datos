package com.educacionit.digitalers.entidades;

public class Sucursal {
	private String nombreSucursal;
	private String ciudadSucursal;
		
	public Sucursal() {
		super();
	}
	public Sucursal(String nombreSucursal, String ciudadSucursal) {
		super();
		this.nombreSucursal = nombreSucursal;
		this.ciudadSucursal = ciudadSucursal;
	}
	
	public String toString() {
		return "Sucursal [nombreSucursal=" + nombreSucursal + ", ciudadSucursal=" + ciudadSucursal + "]";
	}
	
	
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public String getCiudadSucursal() {
		return ciudadSucursal;
	}
	public void setCiudadSucursal(String ciudadSucursal) {
		this.ciudadSucursal = ciudadSucursal;
	}

}
