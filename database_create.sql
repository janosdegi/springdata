
-- create table employee (id int8 not null, name varchar(255), primary key (id))

-- @GeneratedValue(strategy = GenerationType.IDENTITY)
create table employee
(
    id  bigserial not null,
    name varchar(255), primary key (id)
);

create table product
(
    id int4 not null,
    description varchar(255),
    name varchar(255),
    price float8, primary key (id)
);

CREATE TABLE id_gen
(
    gen_name VARCHAR(60) PRIMARY KEY NOT NULL,
    gen_val BIGINT
);


