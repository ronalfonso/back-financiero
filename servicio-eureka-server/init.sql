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

-- Inserts a new tipo_cuenta
INSERT INTO accounts.tipo_cuentas VALUES (1, 'AHORRO');
INSERT INTO accounts.tipo_cuentas VALUES (2, 'CORRIENTE');

-- Inserts a new person
-- INSERT INTO clients.personas VALUES (1, 'Jose Lema', 'MASCULINO', 35, 654665, 'Otavalo sn y principal', '098254785');
-- INSERT INTO clients.personas VALUES (2, 'Marianela Montalvo', 'FEMENINO', 25, 785954, 'Amazonas Y NNUU', '097548965');
-- INSERT INTO clients.personas VALUES (3, 'Juan Osorio', 'MASCULINO', 28, 567977, '13 junio y Equinnoccial', '098874587');
--
-- -- Inserts a new client
-- INSERT INTO clients.clientes VALUES (1, '1234', true, 1);
-- INSERT INTO clients.clientes VALUES (2, '5678', true, 2);
-- INSERT INTO clients.clientes VALUES (3, '1245', true, 3);
--
-- -- Inserts a new account
-- INSERT INTO accounts.cuentas VALUES (1, 478758, 2000, true, 1, 1);
-- INSERT INTO accounts.cuentas VALUES (2, 225487, 100, true, 2, 2);
-- INSERT INTO accounts.cuentas VALUES (3, 495878, 0, true, 3, 1);
-- INSERT INTO accounts.cuentas VALUES (4, 496825, 540, true, 2, 1);