use softlearning;

-- APARTAT PRODUCT
-- Creació taula llibres
create table softlearning.books(
       code int not null,
       price double not null,
       description VARCHAR(100) not null,
       author VARCHAR(100) not null,
       title VARCHAR(100) not null,
       cover VARCHAR(100) not null,
       page int not null,
       gender VARCHAR(100) not null,
       editorial VARCHAR(100) not null,
       isbn VARCHAR(100) not null,
       high double not null,
       width double not null,
       length double not null,
       weight double not null,
       fragil boolean not null,
       depth double not null,
       primary key (code)
)

-- Creació taula cursos
create table softlearning.courses(
       code int not null,
       price double not null,
       description VARCHAR(100) not null,
       hours int not null,
       department VARCHAR(100) not null,
       primary key (code)
)

-- APARTAT PERSON
-- Creació taula clients
create table softlearning.clients(
       name VARCHAR(100) not null,
       surname VARCHAR(100) not null,
       email VARCHAR(100) not null,
       number VARCHAR(100) not null,
       address VARCHAR(100) not null,
       antiquity date not null,
       ident int not null,
       paymentcode VARCHAR(100) not null,
       primary key (ident)
)  

-- Creació taula treballador
create table softlearning.employees(
       name VARCHAR(100) not null,
       surname VARCHAR(100) not null,
       email VARCHAR(100) not null,
       number VARCHAR(100) not null,
       address VARCHAR(100) not null,
       antiquity VARCHAR(100) not null,
       ident int not null,
       departament VARCHAR(100) not null,
       schedule VARCHAR(100) not null,
       bankaccount int not null,
       primary key (ident)
)

-- Creació taula proveïdor
create table softlearning.providers(
       name VARCHAR(100) not null,
       surname VARCHAR(100) not null,
       email VARCHAR(100) not null,
       number VARCHAR(100) not null,
       address VARCHAR(100) not null,
       antiquity VARCHAR(100) not null,
       ident int not null,
       sponsors VARCHAR(100) not null,
       workers int not null,
       socialreason VARCHAR(100) not null,
       primary key(ident)
)

-- Creació taula empresa clienta
create table softlearning.clientcompanys(
       name VARCHAR(100) not null,
       surname VARCHAR(100) not null,
       email VARCHAR(100) not null,
       number VARCHAR(100) not null,
       address VARCHAR(100) not null,
       antiquity VARCHAR(100) not null,
       ident int not null,
       paymentcode VARCHAR(100) not null,
       workers int not null,
       socialreason VARCHAR(100) not null,
       primary key (ident)
)

