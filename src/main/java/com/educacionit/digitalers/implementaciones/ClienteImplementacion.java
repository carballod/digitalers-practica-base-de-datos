package com.educacionit.digitalers.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;
import com.educacionit.digitalers.jdbc.DAO;

public class ClienteImplementacion implements DAO<Cliente, String> {

	private PreparedStatement preparedStatementBuscarPorClavePrimaria;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementActualizar;
	private PreparedStatement preparedStatementListar;

	private Connection conexion;

	public ClienteImplementacion(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	public Cliente buscarPorClavePrimaria(String id_cliente) {
		
		Cliente cliente = null;
		
		String query = "select id_cliente,calle,ciudad,id_empleado from clientes where id_cliente = ?";

		try {

			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}

			preparedStatementBuscarPorClavePrimaria.setString(1, id_cliente);
			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();

			if (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				String calle = resultado.getString("calle");
				String ciudad = resultado.getString("ciudad");
				Integer idEmpleado = resultado.getInt("id_empleado");
				Cliente cliente1 = new Cliente(id, calle, ciudad, idEmpleado);
				return cliente1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertar(Cliente usuario) {
		String query = "insert into clientes (calle, ciudad, idEmpleado) values (?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}

			preparedStatementInsertar.setString(1, usuario.getCalle());
			preparedStatementInsertar.setString(2, usuario.getCiudad());
			preparedStatementInsertar.setLong(3, usuario.getId_empleado());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean actualizar(Cliente usuario) {
		String query = "update clientes set where set calle = ?, ciudad = ? where id_cliente = ?";

		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}

			preparedStatementActualizar.setString(1, usuario.getCalle());
			preparedStatementActualizar.setString(2, usuario.getCiudad());
			preparedStatementActualizar.setInt(3, usuario.getId_cliente());
			preparedStatementActualizar.setInt(3, usuario.getId_empleado());

			return preparedStatementActualizar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminar(Cliente usuario) {
		String query = "delete from clientes where id_cliente = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}
			preparedStatementEliminar.setLong(1, usuario.getId_cliente());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		String query = "select id_cliente,calle,ciudad,id_empleado from clientes where id_cliente = ?";
		
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}
			
			preparedStatementListar.setString(1, "id_cliente");
			
			ResultSet resultado = preparedStatementListar.executeQuery();
			
			while (resultado.next()) {
				Integer id = resultado.getInt("id_cliente");
				String calle = resultado.getString("calle");
				String ciudad = resultado.getString("ciudad");
				Integer idEmpleado = resultado.getInt("id_empleado");
				Cliente cliente = new Cliente(id, calle, ciudad, idEmpleado);
				
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
