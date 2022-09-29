package com.educacionit.digitalers.excepciones;

public class JDBCExcepcion extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public JDBCExcepcion() {
		super();
	}
	
	public JDBCExcepcion(String message) {
		super(message);
	}

}
