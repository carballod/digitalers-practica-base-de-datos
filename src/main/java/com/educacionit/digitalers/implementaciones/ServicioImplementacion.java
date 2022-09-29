package com.educacionit.digitalers.implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Servicio;
import com.educacionit.digitalers.excepciones.JDBCExcepcion;

public class ServicioImplementacion extends ImplementacionGenerica<Servicio,String>{

	public ServicioImplementacion(Connection conexion) throws JDBCExcepcion {
		super(conexion);
		
	}

	public Servicio buscarPorClavePrimaria(String id_cliente) {
		
		Servicio servicio = null;
		String query = "select id_cliente,cuenta_corriente,caja_de_ahorros from servicios_banco where id_cliente = ?";
		
		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			
			preparedStatementBuscarPorClavePrimaria.setString(1, id_cliente);
			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			
			if (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer cuenta = resultado.getInt("cuenta_corriente");
				Integer caja = resultado.getInt("caja_de_ahorros");
				Servicio servicio1 = new Servicio(cuenta, caja);
				return servicio1;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean insertar(Servicio servicio) {
		String query = "insert into servicios_banco (cuenta_corriente,caja_de_ahorros) values (?,?)";
		
		
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}
			
			preparedStatementInsertar.setInt(1, servicio.getCajaAhorros());
			preparedStatementInsertar.setInt(2, servicio.getCuentaorriente());
			
			return preparedStatementInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean actualizar(Servicio servicio) {
		String query = "update servicios_banco set where set caja_de_ahorros = ?, cuenta_corriente = ? where id_cliente = ?";
		
		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}
			preparedStatementActualizar.setInt(1, servicio.getCajaAhorros());
			preparedStatementActualizar.setInt(2, servicio.getCuentaorriente());
			
			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean eliminar(Servicio servicio) {
		String query = "delete from servicios_banco where id_cliente = ?";
		
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}
			preparedStatementEliminar.setLong(1, servicio.getCajaAhorros());
			preparedStatementEliminar.setLong(2, servicio.getCuentaorriente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Servicio> listar() {
		List<Servicio> servicios = new ArrayList<>();
		
		String query = "select * from servicios_banco where id_cliente = ?";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}
			preparedStatementListar.setString(1, "id_cliente");
			ResultSet resultado = preparedStatementListar.executeQuery();
			
			while (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				Integer caja = resultado.getInt("caja_de_ahorros");
				String cuenta = resultado.getString("cuenta_corriente");
				Servicio servicio = new Servicio(id, caja);
				
				servicios.add(servicio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

}
