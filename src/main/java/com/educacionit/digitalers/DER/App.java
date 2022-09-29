package com.educacionit.digitalers.DER;

import com.educacionit.digitalers.conexiones.AdministradorMariaDB;
import com.educacionit.digitalers.implementaciones.ClienteImplementacion;


public class App {
    public static void main( String[] args ){
    	
    	AdministradorMariaDB administradorMariaDB = AdministradorMariaDB.getadmiAdministradorMariaDB();
    	ClienteImplementacion clienteImplementacion = new ClienteImplementacion(administradorMariaDB.getConexion());

        
    }
}
