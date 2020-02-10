create database dbmesapartes;
use dbmesapartes;
create table tabla_persona(
dni varchar(8) primary key,
appaterno varchar(100) not null,
appmaterno varchar(100) not null,
Nombres varchar(150) not null,
email varchar(100) null,
direccion varchar(200) null,
telefono varchar(12) null
);
create table tabla_cargo(
id_cargo int auto_increment primary key,
nombre varchar(100),
dni varchar(8),
foreign key (dni) references tabla_persona(dni) 
);
create table tabla_institucion(
id_institucion int auto_increment primary key,
nombre varchar(150)
);
create table tabla_proceso(
id_proceso int auto_increment primary key,
nombre varchar(150) not null,
descripcion varchar(250) null,
plazoproceso int null
);
create table tabla_area(
id_area varchar(200) primary key,
nombre varchar(150),
id_areapadre varchar(200) null,
id_responsable int null,
foreign key (id_areapadre) references tabla_area(id_area),
foreign key (id_responsable) references tabla_cargo(id_cargo)
);
create table tabla_usuario(
id_usuario int auto_increment primary key,
usuario varchar(50) not null,
contrasena varchar(50) not null,
dni varchar(8),
id_area varchar(200),
foreign key (dni) references tabla_persona(dni),
foreign key (id_area) references tabla_area(id_area)
);
create table tabla_componente(
id_componente int auto_increment primary key,
nombre varchar(200)
);
create table tabla_maestro(
id_maestro int auto_increment primary key,
nombre varchar(250) 
);
create table tabla_privilegio(
id_privilegio int auto_increment,
id_usuario int,
id_maestro int,
id_componente int,
esactivo bit,
primary key ( id_privilegio, id_usuario, id_maestro, id_componente),
foreign key (id_usuario) references tabla_usuario(id_usuario),
foreign key (id_maestro) references tabla_maestro(id_maestro),
foreign key (id_componente) references tabla_componente(id_componente)
);
create table tabla_ingreso(
id_ingreso int not null auto_increment,
id_correlativo int not null,
id_usuario int not null,
asunto varchar(250) not null,
documentoingresado varchar(250) not null, 
id_proceso int null,
fecha_ingreso datetime not null,
fecha_derivado datetime null, 
fecha_recepcion datetime null,
id_institucion int null,
dni varchar(8) null,
id_area_derivar varchar(200) not null,
es_proceso_concluido bit null,
observaciones varchar(250) null,
primary key (id_ingreso,id_correlativo),
foreign key (id_proceso) references tabla_proceso(id_proceso), 
foreign key (id_institucion) references tabla_institucion(id_institucion),
foreign key (dni) references tabla_persona(dni),
foreign key (id_area_derivar) references tabla_area(id_area),
foreign key (id_usuario) references tabla_usuario(id_usuario)
);
