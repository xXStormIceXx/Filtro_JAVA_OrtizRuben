CREATE DATABASE Misiones_Ninja;

USE Misiones_Ninja;

create table mision (
    mision_id int primary key auto_increment,
    name varchar(45),
    Continente varchar(45),
    Aldea varchar(45),
    Distrito varchar(50),
    max_capacidad_ninja int,
    max_capacidad_mision int,
    date date,
    time time,
    organizador varchar(50),
    rango_clasificacion int,
    status enum('active', 'finished', 'pending')
);

create table actividad_ninja (
    actividad_ninja_id int primary key auto_increment,
    name varchar(50)
);

create table habilidades (
    habilidades_id int primary key auto_increment,
    name varchar(50)
);

create table Ninja (
    Ninja_id int primary key auto_increment,
    name varchar(50),
    identificador int(40),
    cumpleanos varchar(50),
    status enum('Mision asignada', 'Ninguna Mision', 'Mision Iniciada', 'Mision Terminada'),
    habilidades_id int,
    foreign key (habilidades_id) references habilidades(habilidades_id),
    mision_id int,
    foreign key (mision_id) references event(mision_id),
    Actividad_ninja_id int,
    foreign key (actividad_ninja_id) references actividad_ninja(actividadpersonal_id)
);