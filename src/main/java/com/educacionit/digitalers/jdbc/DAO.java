package com.educacionit.digitalers.jdbc;


public interface DAO<E, K> {
	
	E buscarPorClavePrimaria(K k);
	
	boolean insertar(E e);
	
	boolean actualizar(E e);
	
	boolean eliminar(E e);
	

}