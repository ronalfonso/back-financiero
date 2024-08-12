CREATE SCHEMA clients;
CREATE SCHEMA accounts;

CREATE TABLE IF NOT EXISTS clients.personas
(
    id             serial PRIMARY KEY,
    nombre         varchar NOT NULL,
    genero         varchar NOT NULL,
    edad           integer NOT NULL,
    identificacion integer NOT NULL UNIQUE,
    direccion      varchar(150) NOT NULL,
    telefono       varchar
);

CREATE TABLE IF NOT EXISTS clients.clientes
(
    cliente_id      serial PRIMARY KEY,
    contraseña     varchar NOT NULL,
    estado         boolean NOT NULL DEFAULT TRUE,
    id             integer NOT NULL DEFAULT 0,
    CONSTRAINT FK_PERSONA FOREIGN KEY (id) REFERENCES clients.personas (id)
);

CREATE TABLE IF NOT EXISTS accounts.cuentas
(
    id             serial PRIMARY KEY,
    numero_cuenta  integer NOT NULL UNIQUE,
    saldo_inicial  integer NOT NULL,
    estado         boolean NOT NULL DEFAULT TRUE,
    cliente_id     integer NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts.movimientos
(
    id             serial PRIMARY KEY,
    fecha          timestamp NOT NULL,
    tipo_movimiento varchar NOT NULL,
    valor          numeric NOT NULL,
    saldo          numeric NOT NULL,
    cuenta_id      integer NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES accounts.cuentas(id)
);

CREATE TABLE IF NOT EXISTS accounts.tipo_cuentas
(
    id             serial PRIMARY KEY,
    nombre         varchar NOT NULL
);

ALTER TABLE accounts.cuentas
    ADD COLUMN tipo_cuenta_id integer,
    ADD FOREIGN KEY (tipo_cuenta_id) REFERENCES accounts.tipo_cuentas(id);