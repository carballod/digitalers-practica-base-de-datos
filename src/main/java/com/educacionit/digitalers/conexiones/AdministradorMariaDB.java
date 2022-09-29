package com.educacionit.digitalers.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AdministradorMariaDB {
	
	private Connection conexion;
	private static AdministradorMariaDB administradorMariaDB;
	
	private AdministradorMariaDB() {
		super();
		setConexion();
	}
	
	public static AdministradorMariaDB getadmiAdministradorMariaDB() {
		if (administradorMariaDB == null) {
			administradorMariaDB = new AdministradorMariaDB();
		}
		return administradorMariaDB;
	}
	

	public Connection getConexion() {
		return conexion;
	}


	private void setConexion() {
		String url = "jdbc:mariadb://localhost:3306/sistemabancario";
		String usuario = "root";
		String clave = "";
		String driver = "org.mariadb.jdbc.Driver";
		
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
