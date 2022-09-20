package com.educacionit.digitalers.DER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ){
        String url = "jdbc:mariadb://localhost:3306/sistemabancario";
        String usuario = "root";
        String clave = "";
        String driver = "org.mariadb.jdbc.Driver";
        
        
        try {
			Class.forName(driver);
			Connection conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("se realizo la conexion de forma exitosa");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
    }
}
