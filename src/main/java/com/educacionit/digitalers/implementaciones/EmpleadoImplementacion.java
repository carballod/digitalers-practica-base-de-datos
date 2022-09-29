package com.educacionit.digitalers.implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;
import com.educacionit.digitalers.entidades.Empleado;
import com.educacionit.digitalers.excepciones.JDBCExcepcion;

public class EmpleadoImplementacion extends ImplementacionGenerica<Empleado, String> {

	public EmpleadoImplementacion(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	public Empleado buscarPorClavePrimaria(String id_cliente) {
		Empleado empleado = null;
		String query = "select * from empleados where id_cliente = ?";
		
		
		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, id_cliente);
			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			
			if (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer idEmpleado = resultado.getInt("id_empleado");
				Integer idJefe = resultado.getInt("id_jefe");
				String sucursal = resultado.getString("sucursal");
				Integer telefono = resultado.getInt("telefono");
				String cargo = resultado.getString("cargo");
				Empleado empleado1 = new Empleado(idEmpleado, idJefe, sucursal, telefono, cargo, null);
				
				return empleado1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Empleado empleado) {
		String query = "insert into empleados (id_jefe, sucursal, telefono, cargo, fecha_incorporacion) values (?,?,?,?,?)";
		
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}
			preparedStatementInsertar.setLong(1, empleado.getId_jefe());
			preparedStatementInsertar.setString(2, empleado.getSucursal());
			preparedStatementInsertar.setInt(3, empleado.getTelefono());
			preparedStatementInsertar.setString(4, empleado.getCargo());
			
			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean actualizar(Empleado empleado) {
		String query = "update empleados set where set id_jefe = ?, sucursal = ?, telefono = ?, cargo = ?, fecha_incorporacion = ? where id_empleado = ?";
		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}
			
			preparedStatementActualizar.setLong(1, empleado.getId_jefe());
			preparedStatementActualizar.setString(2, empleado.getSucursal());
			preparedStatementActualizar.setInt(3, empleado.getTelefono());
			preparedStatementActualizar.setString(4, empleado.getCargo());
			
			return preparedStatementActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Empleado empleado) {
		String query = "delete from empleados where id_empleado = ?";
		
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}
			preparedStatementActualizar.setLong(1, empleado.getId_empleado());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Empleado> listar() {
		List<Empleado> empleados = new ArrayList<>();
		
		String query = "set where set id_jefe, sucursal, telefono, cargo, fecha_incorporacion where id_empleado = ?";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}
			preparedStatementListar.setString(1, "id_empleado");
			
			ResultSet resultado = preparedStatementListar.executeQuery();
			
			while (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer idEmpleado = resultado.getInt("id_empleado");
				Integer idJefe = resultado.getInt("id_jefe");
				String sucursal = resultado.getString("sucursal");
				Integer telefono = resultado.getInt("telefono");
				String cargo = resultado.getString("cargo");
				
				Empleado empleado = new Empleado(idEmpleado, idJefe, sucursal, telefono, cargo, null);
				
				empleados.add(empleado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
