package com.educacionit.digitalers.entidades;

import java.time.LocalDate;

public class Empleado {
	private Integer id_empleado;
	private Integer id_jefe;
	private String sucursal;
	private Integer telefono;
	private String cargo;
	private LocalDate fechaIncorporacion;
	
	
	public Empleado() {
		super();
	}

	public Empleado(Integer id_empleado, Integer id_jefe, String sucursal, Integer telefono, String cargo,
			LocalDate fecha_incorporacion) {
		super();
		this.id_empleado = id_empleado;
		this.id_jefe = id_jefe;
		this.sucursal = sucursal;
		this.telefono = telefono;
		this.cargo = cargo;
		this.fechaIncorporacion = fecha_incorporacion;
	}

	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", id_jefe=" + id_jefe + ", sucursal=" + sucursal
				+ ", telefono=" + telefono + ", cargo=" + cargo + ", fecha_incorporacion=" + fechaIncorporacion + "]";
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Integer getId_jefe() {
		return id_jefe;
	}

	public void setId_jefe(Integer id_jefe) {
		this.id_jefe = id_jefe;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFecha_incorporacion() {
		return fechaIncorporacion;
	}

	public void setFecha_incorporacion(LocalDate fecha_incorporacion) {
		this.fechaIncorporacion = fecha_incorporacion;
	}
	
	
}

