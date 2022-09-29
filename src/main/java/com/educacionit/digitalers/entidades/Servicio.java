package com.educacionit.digitalers.entidades;

public class Servicio {
	private Integer cuentaorriente;
	private Integer cajaAhorros;
	
	
	public Servicio() {
		super();
	}

	public Servicio(Integer cuentaorriente, Integer cajaAhorros) {
		super();
		this.cuentaorriente = cuentaorriente;
		this.cajaAhorros = cajaAhorros;
	}

	public String toString() {
		return "Servicio [cuentaorriente=" + cuentaorriente + ", cajaAhorros=" + cajaAhorros + "]";
	}
	
	public Integer getCuentaorriente() {
		return cuentaorriente;
	}
	public void setCuentaorriente(Integer cuentaorriente) {
		this.cuentaorriente = cuentaorriente;
	}
	public Integer getCajaAhorros() {
		return cajaAhorros;
	}
	public void setCajaAhorros(Integer cajaAhorros) {
		this.cajaAhorros = cajaAhorros;
	}

}
