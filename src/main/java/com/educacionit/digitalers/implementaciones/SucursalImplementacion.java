package com.educacionit.digitalers.implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.educacionit.digitalers.entidades.Sucursal;
import com.educacionit.digitalers.excepciones.JDBCExcepcion;

public class SucursalImplementacion extends ImplementacionGenerica<Sucursal, String>{

	public SucursalImplementacion(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	public Sucursal buscarPorClavePrimaria(String id_cliente) {
		
		Sucursal sucursal = null;
		String query = "select * from sucursal_banco where id_cliente = ?";
		
		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, id_cliente);
			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			
			if (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer idEmpleado = resultado.getInt("id_empleado");
				String ciudad = resultado.getString("ciudad");
				String nombreSucursal = resultado.getString("nombre_sucursal");
				Sucursal sucursal1 = new Sucursal(nombreSucursal, ciudad);
				return sucursal1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Sucursal sucursal) {
		String query = "insert into sucursal_banco (ciudad,nombre_sucursal) values (?,?,?)";
		
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}
			preparedStatementInsertar.setString(1, sucursal.getCiudadSucursal());
			preparedStatementInsertar.setString(2, sucursal.getNombreSucursal());
			
			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean actualizar(Sucursal sucursal) {
		String query = "update sucursal_banco set where set ciudad = ?, nombre_sucursal = ? where id_cliente = ?";
		
		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}
			preparedStatementActualizar.setString(1, sucursal.getCiudadSucursal());
			preparedStatementActualizar.setString(2, sucursal.getNombreSucursal());
			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Sucursal sucursal) {
		String query = "delete from sucursal_banco where id_cliente = ?";
		
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}
			
			preparedStatementEliminar.setString(1, sucursal.getCiudadSucursal());
			preparedStatementEliminar.setString(2, sucursal.getNombreSucursal());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Sucursal> listar() {
		List<Sucursal> sucursales = new ArrayList<>();
		
		String query = "select * from sucursal_banco where id_cliente = ?";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}
			preparedStatementListar.setString(1, "id_cliente");
			ResultSet resultado = preparedStatementListar.executeQuery();
			
			while(resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer idEmpleado = resultado.getInt("id_empleado");
				String ciudad = resultado.getString("ciudad");
				String nombreSucursal = resultado.getString("nombre_sucursal");
				Sucursal sucursal = new Sucursal(nombreSucursal, ciudad);
				sucursales.add(sucursal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
