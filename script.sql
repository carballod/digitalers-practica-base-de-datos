create database sistemabancario;

use sistemabancario;

create table if not exists empleados(

	id_empleado int auto_increment,
	id_jefe int(20) not null,
	RazonSocial varchar(50) not null,
	fecha_nacimiento timestamp not null,
	sucursal varchar(50) not null,
	ciudad varchar(50) not null default 'Buenos Aires',
	telefono varchar(20) not null,
	cargo varchar(20) not null,
	fecha_incorporacion timestamp default current_timestamp(),

	primary key(id_empleado)
);

-- drop table if exists empleados;


create table if not exists clientes(
	id_cliente int auto_increment,
	RazonSocial varchar(50) not null,
	calle varchar(50) not null,
	ciudad varchar(50) not null default 'Buenos Aires',
	fecha_nacimiento timestamp not null,
	fecha_incorporacion timestamp default current_timestamp(),
	id_empleado int,
	

	primary key(id_cliente),
	foreign key (id_empleado) references empleados (id_empleado)
);

-- drop table if exists clientes;

create table if not exists sucursal_banco(
	id_cliente int,
	id_empleado int,
	ciudad varchar(50),
	nombre_sucursal varchar(50),
	
	primary key (nombre_sucursal),
	foreign key (id_cliente) references clientes (id_cliente),
	foreign key (id_empleado) references empleados (id_empleado)
);

-- drop table if exists sucursal_banco;

create table if not exists servicios_banco(
	id_cliente int,
	cuenta_corriente int auto_increment,
	caja_de_ahorros boolean,
	
	primary key (cuenta_corriente),
	foreign key (id_cliente) references clientes (id_cliente)
);